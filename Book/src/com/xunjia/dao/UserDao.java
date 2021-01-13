package com.xunjia.dao;

import com.xunjia.pojo.User;

public interface UserDao {

    /**
     * 根据name查询用户名是否存在
     *
     * @param name
     * @return
     */
    public User queryUserByName(String name);

    /**
     * 根据用户名和命名查询用户信息
     *
     * @param name
     * @param pwd
     * @return
     */
    public User queryUserByNameAndPWD(String name, String pwd);

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    public int saveUser(User user);
}
