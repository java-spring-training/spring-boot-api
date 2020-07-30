package com.example.jp.controller.student;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Validated
public class StudentController {

    @GetMapping("/getParamFromQueryStringToObject")
    public String getParamFromQueryStringToObject(final StudentModelAttribute studentModelAttribute) {

        return studentModelAttribute.getName() + " - " + studentModelAttribute.getGender();
    }

    @GetMapping("/getParamFromPathVariableToObject/{name}/{gender}")
    public String getParamFromPathVariableToObject(final StudentRequest studentRequest) {

        return studentRequest.getName() + " - " + studentRequest.getGender();
    }

    @PostMapping("/getParamFromRequestBodyToObject")
    public String getParamFromRequestBodyToObject(@RequestBody final StudentRequestBody studentRequestBody) {

        return studentRequestBody.getName() + " - " + studentRequestBody.getGender();
    }

    @GetMapping("/getParamFromHeaderToMap")
    public String getParamFromHeaderToMap(@RequestHeader final Map<String, String> headers) {

        return headers.get("name") + " - " + headers.get("gender");
    }

    @GetMapping("/getParamFromQueryString")
    public String getParamFromQueryString(
            @Length(min = 5, max = 10, message = "name length must be between 5 and 10") @RequestParam final String name,
            @RequestParam(required = false) final String gender) {

        return name + " - " + gender;
    }

    @GetMapping("/getParamFromPathVariable/{name}/{gender}")
    public String getParamFromPathVariable(final @PathVariable String name, @PathVariable final String gender) {

        return name + " - " + gender;
    }

    @GetMapping("/getParamFromHeader")
    public String getParamFromHeader(@RequestHeader final String name,
                                     @RequestHeader(required = false) final String gender) {

        return name + " - " + gender;
    }

    @PostMapping("/getListStudentNameFromRequestBody")
    public String getListStudentNameFromRequestBody(final @RequestBody StudentNamesRequestBody studentNamesRequestBody) {

        return String.join(", ", studentNamesRequestBody.getNames());
    }

    @PostMapping("/getListStudentInfoFromRequestBody")
    public String getListStudentInfoFromRequestBody(final @RequestBody StudentsRequestBody studentsRequestBody) {

        return studentsRequestBody.getStudents()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining("\r\n"));
    }

    @GetMapping("/getGraduatedStudent")
    public String getGraduatedStudent(final StudentModelAttribute request) {
        String graduated = request.isGraduated() ? "Graduated: YES" : "Graduated: NO";
        return request.getName() + " - " + request.getGender() + " - " + graduated;
    }
}
