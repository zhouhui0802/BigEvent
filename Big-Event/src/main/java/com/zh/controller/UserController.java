package com.zh.controller;

import com.zh.pojo.Result;
import com.zh.pojo.User;
import com.zh.service.UserService;
import com.zh.utils.JwtUtil;
import com.zh.utils.Md5Util;
import com.zh.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

/*            System.out.println(password);
            System.out.println(Md5Util.getMD5String(password));
            System.out.println(loginUser.getPassword());*/
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("username",loginUser.getUsername());
            String token= JwtUtil.getToken(claims);
            return Result.success(token);
        }

        return Result.error("the password is wrong");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name="Authorization") String token*/){

/*        Map<String,Object> map=JwtUtil.parseToken(token);
        String username=(String)map.get("username");*/

        Map<String,Object> map= ThreadLocalUtil.get();
        String username=(String)map.get("username");
        User user=userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success("update success");
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success("update success");
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){

        String oldPwd=params.get("old_pwd");
        String newPwd=params.get("new_pwd");
        String rePwd=params.get("re_pwd");

        if(!StringUtils.hasLength(oldPwd)||!StringUtils.hasLength(newPwd)||!StringUtils.hasLength(rePwd)){
            return Result.error("lost of necessary data");
        }

        Map<String,Object> map=ThreadLocalUtil.get();
        String username=(String)map.get("username");
        User loginUser=userService.findByUserName(username);

        if(!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            return Result.error("original password was wrong");
        }

        if(!rePwd.equals(newPwd)){
            return Result.error("the new password is different twice");
        }

        userService.updatePwd(newPwd);
        return Result.success("update password success");
    }
}
