package com.zh.controller;

import com.zh.pojo.Result;
import com.zh.pojo.User;
import com.zh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result register(String username,String password){

        User user=userService.findByUserName(username);
        if(user==null){
            userService.registerUser(username,password);
            return Result.success();
        }else{
            return Result.error("the user already exist");
        }
    }
}
