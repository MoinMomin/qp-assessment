package com.shopi.grocery.exception;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserNotFound extends RuntimeException{

    public UserNotFound(String exceptionDesc){
        super(exceptionDesc);
    }
}
