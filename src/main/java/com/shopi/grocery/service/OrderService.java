package com.shopi.grocery.service;

import com.shopi.grocery.model.Order;

public interface OrderService {
    public Order createOrder(Order order);
    public Order updateorder(Order order);

}
