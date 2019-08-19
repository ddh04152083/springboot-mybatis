package com.ddh.mybatis.mapperTest;

import com.ddh.mybatis.entity.User;
import com.ddh.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <Description> <br>
 *
 * @author ddh<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/08/19 22:02 <br>
 * @see com.ddh.mybatis <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyBatisTest {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据id查询到一条数据
     */
    @Test
    public void getOne() {
        User user = userMapper.getOne(1);
        Assert.assertNotNull(user);
    }

    /**
     * 插入map
     */
    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "dongdahai");
        map.put("password", "123456");
        int result = userMapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    /**
     * 插入对象
     */
    @Test
    public void insertByObject() {
        User user = new User();
        user.setUserName("wangjiawang");
        user.setPassWord("1111");
        int result = userMapper.insertByObject(user);
        Assert.assertEquals(1, result);
    }

    /**
     * 查询所有
     */
    @Test
    public void getAll() {

        List<User> result = userMapper.getAll();
        Assert.assertNotEquals(0, result.size());
    }

    /**
     * 更新根据 参数
     */
    @Test
    public void updateUserById() {
        int result = userMapper.updateUserById("chenqi", 1);
        Assert.assertEquals(1, result);
    }

    /**
     * 更新根据对象
     */
    @Test
    public void updateByObject() {
        User user = new User();
        user.setId(4);
        user.setUserName("kangxi");
        user.setPassWord("1111");
        int result = userMapper.updateByObject(user);
        Assert.assertEquals(1, result);
    }

    /**
     * 根据id进行删除
     */
    @Test
    public void deleteById() {
        int result = userMapper.deleteById(3);
        Assert.assertEquals(1, result);

    }
}
