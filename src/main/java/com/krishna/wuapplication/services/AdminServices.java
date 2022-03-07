package com.krishna.wuapplication.services;

import com.krishna.wuapplication.models.User;
import com.krishna.wuapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServices {
    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> users = userRepository.findById(Math.toIntExact(id));
        if (users.isPresent()){
            return users.get();
        }

        return null;
    }

    public void addStudent(User user) {
        userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(Math.toIntExact(id));
    }
}
