package com.deep.test.spring;

import com.deep.test.spring.bean.ClassRoom;
import com.deep.test.spring.bean.Student;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author hudepin
 * @Description
 * @ClassName CrycleRefDemo
 * @create_date 2020.08.26 13:53
 * @since 1.2.0
 */
@EnableAsync
public class CrycleRefDemo{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CrycleRefDemo.class);
        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("ApplicationListener event:"+event);
            }
        });
        applicationContext.refresh();
        applicationContext.start();
        applicationContext.stop();
        System.out.println(applicationContext.getBean(Student.class));
        System.out.println(applicationContext.getBean(ClassRoom.class));
        applicationContext.close();
    }
    @EventListener
    @Order(2)
    public void onApplicationListener(ContextRefreshedEvent applicationEvent){
        System.out.printf("[current thread:%s],event:%s\n",Thread.currentThread().getName(),applicationEvent);
    }
    @EventListener
    @Order(1)
    public void onApplicationListener1(ContextRefreshedEvent applicationEvent){
        System.out.printf("[current thread1:%s],event:%s\n",Thread.currentThread().getName(),applicationEvent);
    }
    @Bean
    public Student student(){
        Student student = new Student();
        student.setId(1L);
        student.setAge(18);
        student.setName("hudepin");
        return student;
    }
    @Bean
    public ClassRoom classRoom(){
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(2l);
        classRoom.setName("123132");
        return classRoom;
    }

}
