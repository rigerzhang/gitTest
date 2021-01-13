package com.xunjia.service.impl;

import com.xunjia.dao.UserDao;
import com.xunjia.pojo.User;
import com.xunjia.service.UserService;

import com.xunjia.dao.impl.UserDaoimpl;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoimpl();

    @Override
    public boolean register(User user) {
        if(userDao.saveUser(user)>0)
            return true;
        return false;

    }

    @Override
    public User login(User user) {
        return userDao.queryUserByNameAndPWD(user.getUsr(),user.getPwd());

    }

    @Override
    public boolean isExistUsr(String usr) {
        if(userDao.queryUserByName(usr)!=null)
            return true;
        else
            return false;
    }
}
