package com.shopi.grocery.service;

import com.shopi.grocery.model.Grocery;

import java.util.List;

public interface GroceryService {
    public Grocery addGrocery(Grocery grocery);
    public Grocery updateGrocery(Grocery grocery);
    public boolean deleteGroceryById(long groceryId);
    public List<Grocery> gelGroceryList();
    public Grocery getGroceryById(long id);
}
