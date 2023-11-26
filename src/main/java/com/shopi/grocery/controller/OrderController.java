package com.shopi.grocery.controller;

import com.shopi.grocery.model.Order;
import com.shopi.grocery.service.CustomResponse;
import com.shopi.grocery.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/createorder")
    public ResponseEntity<Map> createorder(@RequestBody Order order){
        orderService.createOrder(order);
        return CustomResponse.ok(order);
    }
    @PutMapping("/updateorder")
    public ResponseEntity<Map> updateorder(@RequestBody Order order){
        orderService.updateorder(order);
        return CustomResponse.ok(order);
    }

}
