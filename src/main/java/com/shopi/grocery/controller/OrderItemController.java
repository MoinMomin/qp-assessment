package com.shopi.grocery.controller;

import com.shopi.grocery.model.OrderItem;
import com.shopi.grocery.service.CustomResponse;
import com.shopi.grocery.service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/orderitem")
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;
    @PostMapping("/addordeleteItem")
    public ResponseEntity<Map> signUp(@RequestBody OrderItem orderItem){
        return CustomResponse.ok(orderItemService.addOrDeleteOrderitem(orderItem));
    }
    @DeleteMapping("deletecart/{orderId}")
    public ResponseEntity<Map> deleteCart(@PathVariable long orderId){
        if(orderItemService.deleteCart(orderId)){
            return CustomResponse.ok("cart delete Successfully");
        }else{
            return CustomResponse.conflict(" something went wrong");
        }
    }
}
