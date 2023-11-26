package com.shopi.grocery.service;

import com.shopi.grocery.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    public List<OrderItem> addOrDeleteOrderitem(OrderItem orderItem);

    public boolean deleteCart(long orderId);
}
