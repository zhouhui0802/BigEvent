package com.zh.controller;

import com.zh.pojo.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name="Authorization") String token, HttpServletResponse response*/){

/*        try{
            Map<String,Object> claims = new HashMap<String,Object>();
            return Result.success("all the article data...");
        }catch(Exception e){
            response.setStatus(401);
            return Result.error("not login");
        }*/

        return Result.success("all the article data...");
    }
}
