package com.xunjia.test;

import com.xunjia.pojo.User;
import com.xunjia.service.UserService;
import com.xunjia.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Test
    public void register() {
        User user=new User(null,"zl","123","123@126.com");

        UserService userService=new UserServiceImpl();

        System.out.println(userService.register(user));

    }

    @Test
    public void login() {
        User user=new User(null,"zl","1234","123@126.com");

        UserService userService=new UserServiceImpl();

        System.out.println(userService.login(user));

    }

    @Test
    public void isExistUsr() {
        UserService userService=new UserServiceImpl();

        System.out.println(userService.isExistUsr("zl1"));
    }
}