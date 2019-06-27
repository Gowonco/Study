package com.springboot.demo.SpringbootTest.base.controller;


import com.springboot.demo.SpringbootTest.base.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class RController {

    @Autowired
    @Qualifier("currentUser")
    private User user;

    @Bean
    public User currentUser() {
        User user = new User(20, "json");
        user.add(linkTo(methodOn(RController.class).setUserName(user.getName())).withSelfRel());
        return user;
    }

    @RequestMapping(path = {"/html/test1", "/html/test2"})
    public String test() {
        return "<html><body><h1>hello</h1></body></html>";
    }

    @RequestMapping(path = "json/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User userTest() {
        return user;
    }

    @RequestMapping(path = "xml/user", produces = MediaType.APPLICATION_XML_VALUE)
    public User userTest1() {
        return user;
    }

    @RequestMapping(path = "/json/user/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public User setUserName(@RequestParam String name) {
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        int a = 10;
        for (int i = 0; i < 32; i++) {

        }
        System.out.println("aa"+a);
    }


}
