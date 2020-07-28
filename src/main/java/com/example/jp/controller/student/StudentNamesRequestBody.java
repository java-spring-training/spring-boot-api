package com.example.jp.controller.student;

import lombok.Data;

import java.util.List;

@Data
public class StudentNamesRequestBody {

    private List<String> names;
}
