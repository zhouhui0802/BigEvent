package com.zh.controller;

import com.zh.pojo.Result;
import com.zh.pojo.User;
import com.zh.service.UserService;
import com.zh.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password){

        User user=userService.findByUserName(username);
        if(user==null){
            userService.registerUser(username,password);
            return Result.success();
        }else{
            return Result.error("the user already exist");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password){

        User loginUser=userService.findByUserName(username);

        if(loginUser==null){
            return Result.error("the username  is wrong");
        }

        if(Md5Util.getMD5String(password).equals(loginUser.getPassword())){
            return Result.success("jwt token is ok");
        }

        return Result.error("the password is wrong");
    }
}
