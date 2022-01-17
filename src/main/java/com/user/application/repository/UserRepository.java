package com.user.application.repository;

import com.user.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findAllById(Long id);
}
