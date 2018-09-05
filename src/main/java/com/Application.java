package com;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author: yangmengjun
 * @date: 2018\9\5 0005 11:41
 */
@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"com.hy"})
public class Application {
    public static void main(String[] args) {
        ConfigurableEnvironment environment = SpringApplication.run(Application.class, args).getEnvironment();
        log.info("Springboot application running.{}",environment.getProperty("spring.profiles.active"));
    }
}
