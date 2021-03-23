package com.wang.dao;

import com.wang.entity.User;

import java.util.List;

/**
 * @auth admin
 * @date
 * @Description
 */
public interface UserDao {

    void save(User user);

    void update(User user);

    void delete(String id);

    List<User> findAll();

    User findById(String id);

}
