package com.shopi.grocery.exceptionhandler;

import com.shopi.grocery.exception.GroceryNotFound;
import com.shopi.grocery.exception.UserNotFound;
import com.shopi.grocery.service.CustomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map> nullPointerExeception(NullPointerException nullPointerException){
        return CustomResponse.ok("error due to null value please check");
    }
    @ExceptionHandler(GroceryNotFound.class)
    public ResponseEntity<Map> groceryNotFoundException(GroceryNotFound groceryNotFound){
        return CustomResponse.ok("grocery not available for tthis id");
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Map> nullPointerExeception(UserNotFound userNotFound){
        return CustomResponse.ok("user not available for tthis id");
    }
}
