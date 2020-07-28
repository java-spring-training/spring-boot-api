package com.example.jp.controller.student;

import lombok.Data;

import java.util.List;

@Data
public class StudentsRequestBody {

    private List<StudentInfo> students;

    @Data
    public static class StudentInfo {
        private String name;
        private String gender;

        @Override
        public String toString() {
            return name + " - " + gender;
        }
    }
}
