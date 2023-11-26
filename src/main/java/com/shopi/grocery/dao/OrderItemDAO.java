package com.shopi.grocery.dao;

import com.shopi.grocery.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemDAO extends JpaRepository<OrderItem,Long> {
    public OrderItem findByOrderIdAndGroceryId(long orderId,long groceryId);
    public List<OrderItem> findByOrderId(long orderId);
}
