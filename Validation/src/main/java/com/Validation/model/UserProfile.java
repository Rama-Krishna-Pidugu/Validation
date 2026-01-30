package com.Validation.model;

import jakarta.validation.constraints.*;

public class UserProfile {

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Field cannot be null")
    @Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Only alphanumeric characters are allowed")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotNull(message = "Field cannot be null")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 65, message = "Age must not exceed 65")
    private Integer age;

    @NotNull(message = "Field cannot be null")
    @Positive(message = "Salary must be positive")
    @Digits(integer = 5, fraction = 2, message = "Number must have up to 5 digits and 2 decimals")
    private java.math.BigDecimal salary;

    @AssertTrue(message = "Must accept terms and conditions")
    private Boolean termsAccepted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public java.math.BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(java.math.BigDecimal salary) {
        this.salary = salary;
    }

    public Boolean getTermsAccepted() {
        return termsAccepted;
    }

    public void setTermsAccepted(Boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }
}
