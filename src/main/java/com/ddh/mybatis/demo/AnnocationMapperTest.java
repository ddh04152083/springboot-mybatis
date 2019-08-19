package com.ddh.mybatis.demo;

import com.ddh.mybatis.entity.User;
import com.ddh.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * <Description> <br>
 *
 * @author Sunny<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/08/19 21:47 <br>
 * @see com.ddh.mybatis.demo <br>
 */
@Slf4j
@SuppressWarnings("all")
public class AnnocationMapperTest {
    public static void main(String[] args) {
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("mybatis/mybatis-config.xml");
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        try {
            Reader reader = encodedResource.getReader();
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader, "dev", new Properties());
            SqlSession sqlSession = factory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getOne(1);
            log.info("user========" + user);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
