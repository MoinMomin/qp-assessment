package com.shopi.grocery.mapper;

import lombok.Data;

@Data
public class CartItemMapper {
    private long orderId;
    private long groceryId;
    private long numberOfQuantity;

}
