package com.shopi.grocery.service;

import com.shopi.grocery.dao.UserDAO;
import com.shopi.grocery.exception.UserNotFound;
import com.shopi.grocery.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDAO userDAO;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User signUp(User user) {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userDAO.save(user);
        }catch (IllegalArgumentException illegalArgumentException){
            throw new IllegalArgumentException(illegalArgumentException);
        }
        return user;
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userUpdatedOpt=userDAO.findById(user.getId());
        if(userUpdatedOpt.isEmpty()){
            throw new UserNotFound("user not found");
        }
       return userDAO.save(user);

    }

    @Override
    public User getUserById(long userId) {
        Optional<User> userOptional=userDAO.findById(userId);
        if(!userOptional.isEmpty()){
            return userOptional.get();
        }
        return null;
    }
}
