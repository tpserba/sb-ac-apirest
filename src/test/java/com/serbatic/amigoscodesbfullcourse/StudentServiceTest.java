package com.serbatic.amigoscodesbfullcourse;

import com.serbatic.amigoscodesbfullcourse.student.Student;
import com.serbatic.amigoscodesbfullcourse.student.StudentRepo;
import com.serbatic.amigoscodesbfullcourse.student.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void addNewStudentMock(){
        Student expectedStudent = new Student("aa", LocalDate.of(1990, Month.FEBRUARY, 25),"aa@bb.com");
        Student testStudent = new Student("aa", LocalDate.of(1990, Month.FEBRUARY, 25),"aa@bb.com");
        Mockito.when(studentRepo.save(testStudent)).thenReturn(expectedStudent);

        final Student result = studentService.addNewStudent(testStudent);
        Assertions.assertEquals(expectedStudent.getName(), result.getName());
    }
}
