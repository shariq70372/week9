package com.sqe.week9.service;

import com.sqe.week9.model.User;
import com.sqe.week9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User save(User user) {
        user = userRepository.save(user);
        return user;
    }
}
