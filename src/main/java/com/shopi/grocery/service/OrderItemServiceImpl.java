package com.shopi.grocery.service;

import com.shopi.grocery.dao.OrderItemDAO;
import com.shopi.grocery.mapper.CartItemMapper;
import com.shopi.grocery.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    OrderItemDAO orderItemDAO;

    @Override
    public List<OrderItem> addOrDeleteOrderitem(OrderItem orderItem) {
      OrderItem orderItemdb=  orderItemDAO.findByOrderIdAndGroceryId(orderItem.getOrderId(),orderItem.getGroceryId());
      if(orderItem.getNumberOfQuantity()!=0){
         if (orderItemdb!=null)
          orderItem.setId(orderItemdb.getId());
          orderItemDAO.save(orderItem);
      }else if (orderItem.getNumberOfQuantity()==0 && orderItemdb!=null){
          orderItemDAO.delete(orderItemdb);
      }

        return orderItemDAO.findByOrderId(orderItem.getOrderId());
    }

    @Override
    public boolean deleteCart(long orderId) {
        try {
            orderItemDAO.deleteAll(orderItemDAO.findByOrderId(orderId));
        }catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }
}
