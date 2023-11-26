package com.shopi.grocery.controller;

import com.shopi.grocery.dao.GroceryDAO;
import com.shopi.grocery.model.Grocery;
import com.shopi.grocery.service.CustomResponse;
import com.shopi.grocery.service.GroceryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/grocery")
public class GroceryController {
    @Autowired
    GroceryService groceryService;
    @PostMapping("/addgrocery")
    public ResponseEntity<Map> addGrocery(@RequestBody Grocery grocery){
        try {
           Grocery grocery1= groceryService.addGrocery(grocery);
            return CustomResponse.ok(grocery1);
        }catch (IllegalArgumentException illegalArgumentException){
            return CustomResponse.conflict(illegalArgumentException.getMessage());
        }
    }
    @GetMapping("/getGroceryById/{groceryId}")
    public ResponseEntity<Map> getGroceryById(@PathVariable long groceryId){
       Grocery grocery= groceryService.getGroceryById(groceryId);
       if(grocery!=null){
           return CustomResponse.ok(grocery);
       }
       return CustomResponse.conflict("not found by this id");
    }
    @GetMapping("/getallgroceries")
    public ResponseEntity<Map> getAllGroceries(){
        return CustomResponse.ok(groceryService.gelGroceryList());

    }
    @PutMapping("/updategrocery/{groceryId}")
    public ResponseEntity<Map> updateGrocery(@PathVariable long groceryId,@RequestBody Grocery grocery){
        try {grocery.setId(groceryId);
            Grocery grocery1= groceryService.updateGrocery(grocery);
            return CustomResponse.ok(grocery1);
        }catch (IllegalArgumentException illegalArgumentException){
            return CustomResponse.conflict(illegalArgumentException.getMessage());
        }
    }
}
