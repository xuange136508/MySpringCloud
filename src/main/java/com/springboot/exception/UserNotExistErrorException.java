package com.springboot.exception;

public class UserNotExistErrorException extends RuntimeException {


    public UserNotExistErrorException() {
        super("用户不存在");
    }
}
