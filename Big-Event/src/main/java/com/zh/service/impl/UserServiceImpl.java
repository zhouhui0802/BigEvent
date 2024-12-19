package com.zh.service.impl;

import com.zh.mapper.UserMapper;
import com.zh.pojo.User;
import com.zh.service.UserService;
import com.zh.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void registerUser(String username, String password) {
        final String md5String= Md5Util.getMD5String(password);
        userMapper.registerUser(username, md5String);
    }
}
