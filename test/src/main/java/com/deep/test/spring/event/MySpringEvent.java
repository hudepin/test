package com.deep.test.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author hudepin
 * @Description
 * @ClassName MySpringEvent
 * @create_date 2020.09.01 10:18
 * @since 1.2.0
 */
public class MySpringEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MySpringEvent(Object source) {
        super(source);
    }
}
