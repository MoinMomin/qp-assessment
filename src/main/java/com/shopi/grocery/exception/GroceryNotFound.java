package com.shopi.grocery.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class GroceryNotFound extends RuntimeException{
    public GroceryNotFound(String message){
        super(message);
    }
}
