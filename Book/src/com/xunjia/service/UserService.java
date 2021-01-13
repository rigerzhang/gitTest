package com.xunjia.service;

import com.xunjia.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public boolean register(User user);

    /**
     * 登入
     * @param user
     */
    public User login(User user);

    /**
     * 检查用户是否存在
     * @return false 不存在，true 已存在
     */
    public boolean isExistUsr(String usr);
}
