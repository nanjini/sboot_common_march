package com.sboot.backend.common.business.mapper;

import com.sboot.backend.common.business.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    List<User> findAll();

    void save(User user);

    void update(User user);

    Optional<User> findById(Integer id);

    Optional<User> findByName(String name);

    void delete(Integer id);


}