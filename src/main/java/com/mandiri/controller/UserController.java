package com.mandiri.controller;

import com.mandiri.entity.Parameter;
import com.mandiri.entity.User;
import com.mandiri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user")
    public User getById(@RequestParam Integer id){
        return userService.getById(id);
    }
    @PostMapping("/user")
    public User addParameter(@RequestBody User user){
        return userService.addUser(user);
    }
}
