package com.wang.controller;

import com.wang.entity.User;
import com.wang.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "用户controller")
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 查询一个
     */
    @ApiOperation("查询一个")
    @GetMapping("/findOne")
    public User findOne(String id) {
        return userService.findById(id);
    }

    @ApiOperation("更新用户")
    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.update(user);
            map.put("success", true);
            map.put("msg", "更新用户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "更新用户信息失败");
        }
        return map;
    }


    /**
     * 删除用户
     */
    @GetMapping("/delete")
    public Map<String, Object> delete(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success", true);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "删除失败");
        }
        return map;
    }

    /**
     * 添加用户
     */
    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
            userService.save(user);
            map.put("success", true);
            map.put("msg", "添加成功");
        return map;
    }

    /**
     * 查询所有用户
     */
    @GetMapping("/findAll")
    public Map<String, Object> findAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        List<User> results = userService.findAll();

        map.put("total", 10);
        map.put("totalPage", 1);
        map.put("page", page);
        map.put("results", results);
        return map;
    }

}
