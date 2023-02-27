package com.serbatic.amigoscodesbfullcourse.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepo repo;

    @Autowired
    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Student> getStudents() {
        return repo.findAll();
    }

    public Student addNewStudent(Student student) {
        Optional<Student> studentByEmail = repo.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email is already taken.");
        }
        repo.save(student);
        return student;
    }

    public void deleteStudent(Long studentId){
        boolean exists = repo.existsById(studentId);
        if(!exists){
        throw new IllegalStateException("Student with id " + studentId + " does not exist.");
        }
        repo.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = repo.findById(studentId).orElseThrow(()-> new IllegalStateException("Student with id: " + studentId + " does not exist."));
        if(name != null && name.length() > 0 && student.getName() != name){
            student.setName(name);
        }
        if(email != null && email.length() > 0 && student.getEmail() != email){
            Optional<Student> studentOptional = repo.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email already taken.");
            }
            student.setEmail(email);
        }

    }
}
