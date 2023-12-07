package com.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.validation.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
