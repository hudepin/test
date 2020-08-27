package com.deep.test.beanInfo;

import com.deep.test.entity.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @author hudepin
 * @Description
 * @ClassName BeanInfoDemo
 * @create_date 2020.07.31 09:51
 * @since 1.2.0
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        BeanInfo user = Introspector.getBeanInfo(User.class);
        Stream.of(user.getBeanDescriptor()).forEach(System.out::println);
        User userInfo = new User();
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("userName",User.class);
        Method method = propertyDescriptor.getWriteMethod();
        method.invoke(userInfo,"hudepin");
        System.out.println(userInfo.getUserName());
    }
}
