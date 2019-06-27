package com.springboot.demo.SpringbootTest.mybatis.demo;

import com.springboot.demo.SpringbootTest.mybatis.mapper.UserMapper;
import com.springboot.demo.SpringbootTest.mybatis.pojo2.User;
import com.springboot.demo.SpringbootTest.mybatis.pojo2.UserExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

public class GeneratorConfigDemo {

    public static void main(String[] args) throws IOException {

        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

        InputStream inputStream=classLoader.getResourceAsStream("mybatis/mybatis-config.xml");

        Reader reader = new InputStreamReader(inputStream,"UTF-8");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = builder.build(reader, "dev", new Properties());

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        UserExample userExample=new UserExample();

        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andIdEqualTo(4);

        List<User> list=userMapper.selectByExample(userExample);
        System.out.println(list.get(0));

        sqlSession.close();

    }
}
