package com.practice.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.practice.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    
}
