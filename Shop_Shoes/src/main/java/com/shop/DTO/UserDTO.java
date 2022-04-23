package com.example.casestudy.DTO;

import javax.validation.constraints.NotEmpty;

public class UserDTO {
    @NotEmpty(message = "Username không được để trống")
    private String username;
    @NotEmpty(message = "Password không được để trống")
    private String password;


    public UserDTO() {
        this.username = username;
        this.password = password;
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
}
