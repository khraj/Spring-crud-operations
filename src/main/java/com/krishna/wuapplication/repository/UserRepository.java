package com.krishna.wuapplication.repository;

import com.krishna.wuapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
