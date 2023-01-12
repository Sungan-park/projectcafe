package com.example.cafe.Repository;

import com.example.cafe.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findOneById(String id);
}