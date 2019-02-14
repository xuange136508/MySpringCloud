package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;


//开启定时任务
//@EnableScheduling
//开启RabbitMq
@EnableRabbit
//开启缓存
@EnableCaching
//扫码MyBatis的Mappper文件
@MapperScan(value = "com.springboot.mapper")
//导入spring的bean
@ImportResource(locations = {"classpath:bean.xml"})
@SpringBootApplication
public class HelloWroldMainApplication {


    public static void main (String[] args){
        //启动应用
        SpringApplication.run(HelloWroldMainApplication.class,args);
    }

}
