package com.shopi.grocery.dao;

import com.shopi.grocery.model.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryDAO extends JpaRepository<Grocery,Long> {
}
