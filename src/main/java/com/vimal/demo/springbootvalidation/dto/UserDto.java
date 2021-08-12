package com.vimal.demo.springbootvalidation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public class UserDto {

    private int id;
    // user name should not be null or empty
    // user name should have at least 2 characters
    @NotNull
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Digits(integer = 6, fraction = 0)
    private BigDecimal salary;
    // email should be a valid email format
    // email should not be null or empty
    @NotNull
    @Email
    private String email;
    // password should not be null or empty
    // password should have at least 8 characters
    @NotNull
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;

    public UserDto() {
    }

    public UserDto(int id, String name, Date dob,BigDecimal salary, String email, String password) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.salary=salary;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
