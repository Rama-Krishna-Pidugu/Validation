package com.Validation.model;

import jakarta.validation.constraints.*;

public class LoginForm {

    @NotNull(message = "Field cannot be null")
    @Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Only alphanumeric characters are allowed")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    private String password;

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
}
