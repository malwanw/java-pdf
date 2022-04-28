package com.mandiri.service;

import com.mandiri.entity.Parameter;
import com.mandiri.entity.User;
import com.mandiri.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getById(Integer id){
        return userRepository.findById(id).get();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
}
