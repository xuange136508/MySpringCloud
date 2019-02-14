package com.spring.eureka.consumer.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buyTicket(){
        System.out.println("UserController buyTicket...");
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return "您购买了"+s;
    }
}
