package com.zh.pojo;

import java.time.LocalDateTime;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class User {

    private Integer id;

    private String username;

    @JsonIgnore
    private String password;

    private String nickname;

    private String email;

    private String userPic;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
