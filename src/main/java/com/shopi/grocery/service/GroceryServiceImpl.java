package com.shopi.grocery.service;

import com.shopi.grocery.dao.GroceryDAO;
import com.shopi.grocery.exception.GroceryNotFound;
import com.shopi.grocery.model.Grocery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GroceryServiceImpl implements GroceryService{
    @Autowired
    GroceryDAO groceryDAO;
    @Override
    public Grocery addGrocery(Grocery grocery) {
        try {
            groceryDAO.save(grocery);
        }catch (IllegalArgumentException illegalArgumentException){
            throw new IllegalArgumentException(illegalArgumentException);
        }
        return grocery;
    }

    @Override
    public Grocery updateGrocery(Grocery grocery) {
       Optional<Grocery> groceryOptional =groceryDAO.findById(grocery.getId());
       if(groceryOptional.isEmpty()) {
           throw new GroceryNotFound("grocery not Found");
       }
       groceryDAO.save(grocery);
        return grocery;
    }

    @Override
    public boolean deleteGroceryById(long groceryId) {
        Optional<Grocery> groceryOptional =groceryDAO.findById(groceryId);
        if(groceryOptional.isEmpty()) {
            throw new GroceryNotFound("grocery not Available");
        }
        Grocery grocery=groceryOptional.get();
        groceryDAO.save(grocery);

        return grocery.isDeleted();
    }

    @Override
    public List<Grocery> gelGroceryList() {

        return groceryDAO.findAll();
    }

    @Override
    public Grocery getGroceryById(long id) {
       Optional<Grocery> groceryOptional= groceryDAO.findById(id);
       if(!groceryOptional.isEmpty()){
           return groceryOptional.get();
       }
        return null;
    }
}
