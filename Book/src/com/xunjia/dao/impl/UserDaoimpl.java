package com.xunjia.dao.impl;

import com.xunjia.dao.UserDao;
import com.xunjia.pojo.User;

public class UserDaoimpl extends BaseAdo implements UserDao {

    @Override
    public User queryUserByName(String name) {
        String sql="select * from t_usr where usr=?";
        return queryForOne(User.class,sql,name);
    }

    @Override
    public User queryUserByNameAndPWD(String name, String pwd) {
        String sql="select * from t_usr where usr=? and pwd=?";
        return queryForOne(User.class,sql,name,pwd);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into t_usr(usr,pwd,email)values(?,?,?)";
        return update(sql,user.getUsr(),user.getPwd(),user.getEmail());
    }
}
