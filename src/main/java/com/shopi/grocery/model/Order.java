package com.shopi.grocery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "`order`")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long customerId;
  /*  @OneToMany(mappedBy = "id")
    private List<OrderItem> cart;*/ // due to join performace issue happen so we can use another method
    private double totalPrice;
    private String orderStatus;
    @JsonProperty(required = false)
    private Date createdAt=new Date();
    @JsonProperty(required = false)
    private Date updatedAt;
}
