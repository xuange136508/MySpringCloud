package com.springboot.config;


import com.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {


    @Bean
    public HelloService helloServiceConfig(){
        System.out.println("给容器添加组件.....");
        return new HelloService();
    }


}
