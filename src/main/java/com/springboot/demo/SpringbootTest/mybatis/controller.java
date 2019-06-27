package com.springboot.demo.SpringbootTest.mybatis;

import com.springboot.demo.SpringbootTest.mybatis.pojo2.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @RequestMapping("/select/user/{id}")
    public User selectUser(@PathVariable int id){
        User user=sqlSessionTemplate.selectOne("com.springboot.demo.SpringbootTest.mybatis.mapper.UserMapper.selectUser",id);
        return user;
    }
}
