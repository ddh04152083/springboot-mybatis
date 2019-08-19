package com.ddh.mybatis.Service.Impl;

import com.ddh.mybatis.Service.UserService;
import com.ddh.mybatis.entity.User;
import com.ddh.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author ddh<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/08/19 22:44 <br>
 * @see com.ddh.mybatis.Service.Impl <br>
 */
@Service
public class IUserService implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getOne(long id) {
        return userMapper.getOne(id);
    }

    @Override
    public int insertByObject(User user) {
        return userMapper.insertByObject(user);
    }

    @Override
    public int updateByObject(User user) {
        return userMapper.updateByObject(user);
    }

    @Override
    public int deleteById(long id) {
        return userMapper.deleteById(id);
    }
}
