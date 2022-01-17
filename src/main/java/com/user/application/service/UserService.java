package com.user.application.service;

import com.user.application.entity.User;
import com.user.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        Optional<User> user=userRepository.findAllById(id);
        if (user.isPresent()){
            return user.get();
        }
        return null;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
