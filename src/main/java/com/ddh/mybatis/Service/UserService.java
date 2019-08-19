package com.ddh.mybatis.Service;

import com.ddh.mybatis.entity.User;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author ddh<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/08/19 22:43 <br>
 * @see com.ddh.mybatis.Service <br>
 */
public interface UserService {
    /**
     * 查询所有
     */
    List<User> getAll();

    User getOne(long id);

    int insertByObject(User user);

    int updateByObject(User user);


    int deleteById(long id);
}
