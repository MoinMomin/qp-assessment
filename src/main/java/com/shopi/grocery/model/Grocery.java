package com.shopi.grocery.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private double price;
    private long inventoryLevel;
    private boolean deleted=false;
    @JsonProperty(required = false)
    private Date createdAt=new Date();
    @JsonProperty(required = false)
    private Date updatedAt;
}
