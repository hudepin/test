package com.deep.test.spring;

import com.deep.test.spring.event.MySpringEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.ErrorHandler;

/**
 * @author hudepin
 * @Description
 * @ClassName EventMulticasterDemo
 * @create_date 2020.09.01 10:15
 * @since 1.2.0
 */
public class EventMulticasterDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EventMulticasterDemo.class);
        context.refresh();
        context.addApplicationListener(new ApplicationListener<MySpringEvent>() {
            @Override
            public void onApplicationEvent(MySpringEvent event) {
                System.out.println(String.format("[Thread:%s] ,event:%s",Thread.currentThread().getName(),event));
                throw new RuntimeException("error in Listener");

            }
        });

        SimpleApplicationEventMulticaster eventMulticaster
                = context.getBean(SimpleApplicationEventMulticaster.class);
        eventMulticaster.setErrorHandler(new ErrorHandler() {
            @Override
            public void handleError(Throwable t) {
                System.out.println("handleError "+t);
            }
        });
        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor("my-task-executor"));
        context.publishEvent(new MySpringEvent("Hello,World"));
        eventMulticaster.removeAllListeners();
        context.close();
    }
}
