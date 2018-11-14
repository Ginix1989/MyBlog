package com.ginix.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BolgApplication extends SpringBootServletInitializer {
    //重写configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)  {
        return application.sources(BolgApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(BolgApplication.class, args);
    }
}
