package com.shopi.grocery.service;

import com.shopi.grocery.dao.OrderDAO;
import com.shopi.grocery.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDAO orderDAO;
    @Override
    public Order createOrder(Order order) {
        orderDAO.save(order);
        return order;
    }

    @Override
    public Order updateorder(Order order) {
        orderDAO.save(order);
        return order;
    }


}
