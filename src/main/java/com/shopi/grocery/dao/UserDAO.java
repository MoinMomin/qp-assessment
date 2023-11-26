package com.shopi.grocery.dao;

import com.shopi.grocery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {
    public User findByUserName(String userName);
}
