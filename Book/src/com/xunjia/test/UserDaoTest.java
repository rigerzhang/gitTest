package com.xunjia.test;

import com.xunjia.dao.UserDao;
import com.xunjia.dao.impl.UserDaoimpl;
import com.xunjia.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void queryUserByName() {
        UserDao userDao=new UserDaoimpl();
        System.out.println(userDao.queryUserByName("admin"));
    }

    @Test
    public void queryUserByNameAndPWD() {
        UserDao userDao=new UserDaoimpl();
        System.out.println(userDao.queryUserByNameAndPWD("admin","admin"));
    }

    @Test
    public void saveUser() {
        User user=new User(null,"zl","123","123@126.com");
        UserDao userDao= new UserDaoimpl();
        System.out.println(userDao.saveUser(user));
    }
}