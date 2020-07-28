package com.example.jp.controller.student;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Validated
public class StudentController {

    @GetMapping("/getParamFromQueryStringToObject")
    public String getParamFromQueryStringToObject(@ModelAttribute StudentModelAttribute studentModelAttribute) {

        return studentModelAttribute.getName() + " - " + studentModelAttribute.getGender();
    }

    @GetMapping("/getParamFromPathVariableToObject/{name}/{gender}")
    public String getParamFromPathVariableToObject(StudentRequest studentRequest) {

        return studentRequest.getName() + " - " + studentRequest.getGender();
    }

    @PostMapping("/getParamFromRequestBodyToObject")
    public String getParamFromRequestBodyToObject(@RequestBody StudentRequestBody studentRequestBody) {

        return studentRequestBody.getName() + " - " + studentRequestBody.getGender();
    }

    @GetMapping("/getParamFromHeaderToMap")
    public String getParamFromHeaderToMap(@RequestHeader Map<String, String> headers) {

        return headers.get("name") + " - " + headers.get("gender");
    }

    @GetMapping("/getParamFromQueryString")
    public String getParamFromQueryString(@RequestParam @Min(5) String name, @RequestParam(required = false) String gender) {

        return name + " - " + gender;
    }

    @GetMapping("/getParamFromPathVariable/{name}/{gender}")
    public String getParamFromPathVariable(@PathVariable String name, @PathVariable String gender) {

        return name + " - " + gender;
    }

    @GetMapping("/getParamFromHeader")
    public String getParamFromHeader(@RequestHeader String name, @RequestHeader(required = false) String gender) {

        return name + " - " + gender;
    }

    @PostMapping("/getListStudentNameFromRequestBody")
    public String getListStudentNameFromRequestBody(@RequestBody StudentNamesRequestBody studentNamesRequestBody) {

        return String.join(", ", studentNamesRequestBody.getNames());
    }

    @PostMapping("/getListStudentInfoFromRequestBody")
    public String getListStudentInfoFromRequestBody(@RequestBody StudentsRequestBody studentsRequestBody) {

        return studentsRequestBody.getStudents()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining("\r\n"));
    }
}
