package com.shopi.grocery.service;

import com.shopi.grocery.model.User;

public interface UserService {
    public User signUp(User user);
    public User updateUser(User user);
    public User getUserById(long userId);
}
