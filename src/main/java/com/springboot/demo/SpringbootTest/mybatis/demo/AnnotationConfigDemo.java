package com.springboot.demo.SpringbootTest.mybatis.demo;


import com.springboot.demo.SpringbootTest.mybatis.annotation.UserMapper;
import com.springboot.demo.SpringbootTest.mybatis.pojo2.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class AnnotationConfigDemo {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

        InputStream inputStream=classLoader.getResourceAsStream("mybatis/mybatis-config.xml");

        Reader reader = new InputStreamReader(inputStream,"UTF-8");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = builder.build(reader, "dev", new Properties());

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);


        User user=userMapper.selectUser(4);
        System.out.println(user);

        sqlSession.close();

    }
}
