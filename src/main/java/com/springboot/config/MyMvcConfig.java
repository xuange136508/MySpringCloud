package com.springboot.config;


import com.springboot.service.HelloService;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        //定制servlet嵌入式容器相关规则
        return new EmbeddedServletContainerCustomizer(){

            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8081);
            }
        };
    }



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/demo").setViewName("success");
    }
}
