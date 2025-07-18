package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String flag;  // admin 或 normal
    private List<User> userInfoList;
}    