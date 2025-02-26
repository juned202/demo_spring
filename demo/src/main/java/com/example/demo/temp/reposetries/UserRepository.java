package com.example.demo.temp.reposetries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.temp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> { }


