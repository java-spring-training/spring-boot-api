package com.example.jp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "class")
@Data
public class StudentConfig {

    private List<Student> students;

    @Data
    public static class Student {
        private String name;
        private String gender;
    }
}
