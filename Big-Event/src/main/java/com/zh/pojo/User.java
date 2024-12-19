package com.zh.pojo;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String userPic;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
