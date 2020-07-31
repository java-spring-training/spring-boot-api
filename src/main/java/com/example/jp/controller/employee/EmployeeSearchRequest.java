package com.example.jp.controller.employee;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class EmployeeSearchRequest {

    @NotNull(message = "'fullName' must not be null")
    private String fullName;
    @NotBlank(message = "'accName' must not be blank")
    private String accName;
    @Length(min = 5, max = 10, message = "'address' length must be between 5 and 10")
    //@Length(min = 5)
    //@Length(max = 10)
    private String address;
    @Pattern(regexp="(^$|[0-9]{10})", message = "'phone' must be 10 digits")
    private String phone;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
}
