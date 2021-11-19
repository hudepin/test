package com.deep.test.spring.annotation.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hudepin
 * @Description
 * @ClassName HelloWorldConfiguration
 * @create_date 2020.09.01 20:57
 * @since 1.2.0
 */
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String helloWorld() {
        return "Hello,World";
    }
}
