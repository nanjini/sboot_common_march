package com.sboot.backend.common.business.service;

import com.sboot.backend.common.business.mapper.UserMapper;
import com.sboot.backend.common.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getUserList() {
        return userMapper.findAll();
    }

    public void joinUser(User user) {
        validateDuplicateMember(user);
        userMapper.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        userMapper.update(user);
    }

    private void validateDuplicateMember(User user) {
        userMapper.findByName(user.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    public Optional<User> findOne(Integer userId) {
        return userMapper.findById(userId);
    }

    public void deleteUser(Integer userId) {
        userMapper.delete(userId);
    }
}
