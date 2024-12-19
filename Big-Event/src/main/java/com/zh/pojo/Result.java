package com.zh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(0,"operate success",data);
    }

    public static <T> Result<T> success() {
        return new Result<>(0,"operate success",null);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(1,message,null);
    }

}
