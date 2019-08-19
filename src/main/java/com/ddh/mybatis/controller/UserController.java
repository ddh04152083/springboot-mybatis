package com.ddh.mybatis.controller;

import com.ddh.mybatis.Service.UserService;
import com.ddh.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author ddh<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/08/19 22:45 <br>
 * @see com.ddh.mybatis.controller <br>
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @return
     */
    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/get/{id}")
    public User getById(@PathVariable("id") long id) {
        return userService.getOne(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
         userService.deleteById(id);
    }
    @PostMapping("/insert")
    public void insert(@RequestBody User user){
        userService.insertByObject(user);
    }
    @PostMapping("/update")
    public void update(@RequestBody User user){
        userService.updateByObject(user);
    }

}
