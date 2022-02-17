package com.krishna.wuapplication.repository;

import com.krishna.wuapplication.models.Student;
import com.krishna.wuapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);

}
