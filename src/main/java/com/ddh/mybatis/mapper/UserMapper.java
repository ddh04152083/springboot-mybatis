package com.ddh.mybatis.mapper;

import com.ddh.mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <Description> <br>
 *
 * @author Sunny<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/08/19 21:24 <br>
 * @see com.ddh.mybatis.mapper <br>
 */

@Repository
public interface UserMapper {
    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userName", column = "username"),
            @Result(property = "passWord", column = "password")
    })
    @Select("select id,username,password from user where id=#{id}")
    User getOne(long id);

    /**
     * @return
     */
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userName", column = "username"),
            @Result(property = "passWord", column = "password")
    })
    @Select("select id,username,password from user")
    List<User> getAll();

    /**
     * 根据map 进行插入
     *
     * @param map
     * @return
     */
    @Insert("insert into user(username, password) values (#{username, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR})")
    int insertByMap(Map<String, Object> map);

    /**
     * 根据object 进行插入
     *
     * @param user
     * @return
     */
    @Insert("insert into user(username, password) values (#{userName, jdbcType=VARCHAR}, #{passWord, jdbcType=VARCHAR})")
    int insertByObject(User user);

    /**
     * 根据参数进行更新
     *
     * @param userName
     * @param id
     * @return
     */
    @Update("update user set username=#{userName} where id=#{id}")
    int updateUserById(@Param("userName") String userName, @Param("id") long id);

    /**
     * 根据Object 进行更新
     *
     * @param user
     * @return
     */
    @Update("update user set username=#{userName},password=#{passWord} where id=#{id}")
    int updateByObject(User user);

    @Delete("delete from user where id=#{id}")
    int deleteById(@Param("id") long id);
}
