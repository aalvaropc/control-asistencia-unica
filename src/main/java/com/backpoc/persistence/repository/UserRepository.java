package com.backpoc.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backpoc.persistence.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByPassword(String password);
}
