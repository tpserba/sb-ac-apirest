package com.serbatic.amigoscodesbfullcourse.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Interface responsible for data access
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    //@Query("SELECT s FROM student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
    
}
