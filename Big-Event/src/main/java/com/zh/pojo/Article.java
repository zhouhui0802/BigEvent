package com.zh.pojo;

import java.time.LocalDateTime;

import com.zh.anno.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class Article {

    private Integer id;

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    @URL
    private String coverImg;

    @State
    private String state;

    @NotNull
    private Integer categoryId;

    private Integer createUser;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
