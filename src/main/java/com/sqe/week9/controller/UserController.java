package com.sqe.week9.controller;

import com.sqe.week9.model.User;
import com.sqe.week9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public User save(@RequestBody User user){
        return userService.save(user);
    }
}
