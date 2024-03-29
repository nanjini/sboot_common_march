package com.sboot.backend.common.api.controller;

import com.sboot.backend.common.business.model.User;
import com.sboot.backend.common.business.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userServiceImpl.getUserList();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUser(@PathVariable Integer userId) {
        return userServiceImpl.findOne(userId);
    }

    @PostMapping("/new")
    public void addUser(@RequestBody User user) {
        userServiceImpl.joinUser(user);
    }

    @PutMapping("/users/{userId}")
    public void modUser(@PathVariable Integer userId, @RequestBody User user) {
        user.setId(userId);
        userServiceImpl.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void delUser(@PathVariable Integer userId) {
        userServiceImpl.deleteUser(userId);
    }
}