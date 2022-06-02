package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserId(long userId);

}
