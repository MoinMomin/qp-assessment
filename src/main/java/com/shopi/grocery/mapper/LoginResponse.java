package com.shopi.grocery.mapper;

import com.shopi.grocery.model.User;
import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private User user;
}
