package com.springboot;


import com.springboot.bean.Employee;
import com.springboot.bean.EsBean;
import com.springboot.repository.EsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {


    @Autowired
    ApplicationContext context;

    @Test
    public void testHelloworld(){
        boolean b = context.containsBean("helloService");
        System.out.println(b);
        boolean b2 = context.containsBean("helloServiceConfig");
        System.out.println(b2);

    }

    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void testLog(){
        logger.info("Info日志级别...");
    }


    @Test
    public void testMyBatis(){

    }

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    @Test
    public void testRedisTemplate(){
        String value = (String) redisTemplate.opsForValue().get("a");
        System.out.println("redis ==> " + value);
    }

    @Test
    public void testRedisTemplatePut(){
        Employee empById = new Employee();
        empById.setLastName("Me");
        empById.setdId(2);
        empRedisTemplate.opsForValue().set("emp-01",empById);
    }

    @Test
    public void testRedisTemplateGet(){
        Employee e = empRedisTemplate.opsForValue().get("emp-01");
        System.out.println("redis ==> " + e.toString());
    }


    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 1、单播（点对点）
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","queue2",map);

    }
    //接受数据,如何将数据自动的转为json发送出去
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("queue2");
        System.out.println(o.getClass());
        System.out.println(o);
    }


    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        rabbitTemplate.convertAndSend("exchange.fanout","",map);
    }


    /**
     * http://120.79.39.181:9200/
     * 测试 elasticsearch
     * */
    @Autowired
    EsRepository esRepository;
    @Test
    public void testElasticsearch1(){
        EsBean book = new EsBean();
		book.setId(1);
		book.setBookName("西游记");
		book.setAuthor("吴承恩");
        esRepository.index(book);

        //查询：http://120.79.39.181:9200/weiyi/book/_search
    }
    @Test
    public void testElasticsearch2(){
        for (EsBean book : esRepository.findByBookNameLike("游")) {
            System.out.println(book);
        }
    }


}
