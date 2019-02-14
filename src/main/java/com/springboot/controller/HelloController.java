package com.springboot.controller;

import com.springboot.exception.UserNotExistErrorException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "helloWorld";
    }


    @RequestMapping("/exception")
    public String exception(){
        throw new UserNotExistErrorException();
    }

}
