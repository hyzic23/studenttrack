package com.twentythree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

//@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class StudentdalApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentdalApplication.class, args);
    }

}
