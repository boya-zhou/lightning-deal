package com.seckillhigh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import com.seckillhigh.config.MyBPP;

@SpringBootApplication
@EnableCaching
//@PropertySource({"classpath:application.properties"})
@ComponentScan("com.seckillhigh")
public class MainApplication {
//
//    @Bean
//    public MyBPP myBeanPostProcessor() {
//        return new MyBPP();
//    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

    }
}