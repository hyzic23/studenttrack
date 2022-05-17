package com.twentythree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
//@ComponentScan(basePackages = "com.twentythree")
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.twentythree")
//@EnableJpaRepositories  //(basePackages = {"pl.hypeapp.episodie.dataproviders"})
//@EntityScan(basePackages = {"com.twentythree"})
@SpringBootApplication
public class StudentdalApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentdalApplication.class, args);
    }

}
