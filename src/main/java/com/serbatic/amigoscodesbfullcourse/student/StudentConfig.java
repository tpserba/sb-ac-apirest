package com.serbatic.amigoscodesbfullcourse.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo) {
        return args-> {
            Student john = new Student(
                    "John",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "JohnDoe@foobar.com"
            );

            Student laura = new Student(
                    "Laura",
                    LocalDate.of(1990, Month.FEBRUARY, 25),
                    "LauraMoo@foobar.com"
            );
            repo.saveAll(List.of(john, laura));
        };
    }
}
