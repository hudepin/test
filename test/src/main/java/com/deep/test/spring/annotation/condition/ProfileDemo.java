package com.deep.test.spring.annotation.condition;

import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author hudepin
 * @Description
 * @ClassName ProfileDemo
 * @create_date 2020.09.01 21:51
 * @since 1.2.0
 */
@Configuration
public class ProfileDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ProfileDemo.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setDefaultProfiles("even");
        context.refresh();
        int number=context.getBean("number",Integer.class);
        System.out.println(number);
        context.close();

    }

    /**
     * 奇数
     * @return
     */
    @Bean("number")
    @Profile("odd")
    public int odd(){
        return 1;
    }

    /**
     * 偶数
     * @return
     */
    @Bean("number")
    @Conditional(EvenProfileCondition.class)
    public int even(){
        return 2;
    }
}
