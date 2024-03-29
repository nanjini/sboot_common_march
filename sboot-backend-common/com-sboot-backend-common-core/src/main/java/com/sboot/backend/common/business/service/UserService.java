package com.sboot.backend.common.business.service;

import com.sboot.backend.common.business.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUserList();

    void joinUser(User user);

    void updateUser(User user);

    Optional<User> findOne(Integer userId);

    void deleteUser(Integer userId);
}