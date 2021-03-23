package com.wang.service;

import com.wang.dao.UserDao;
import com.wang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @auth admin
 * @date
 * @Description
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        //修改任何数据，需要更新缓存中的数据

        String key = prefix + user.getId();
        redisTemplate.delete(key);

        userDao.update(user);
    }

    public void delete(String id) {
        userDao.delete(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public static final String prefix = "string:user:";

    public User findById(String id) {
        //存入redis的真实key
        String key = prefix + id;
        User user = null;
        // User user = new User();
        //查缓存，如果没有，则查数据库，并把数据放入缓存
        //如果有数据，直接返回，不需要查数据库

        ValueOperations valueOperations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(key)) {
            //如果有数据，直接返回，不需要查数据库
            user = (User) valueOperations.get(key);
            if (user == null) {
                user = userDao.findById(id);
                valueOperations.set(key, user);
                redisTemplate.expire(key, 30 * 60, TimeUnit.SECONDS);
            }

        } else {
            //key不存在，说明缓存中没有数据
            //查数据库
            user = userDao.findById(id);
            if (user != null) {
                //把数据库中查到的数据放入缓存中
                valueOperations.set(key, user);
                redisTemplate.expire(key, 30 * 60, TimeUnit.SECONDS);
            }
        }
        return user;
    }

}
