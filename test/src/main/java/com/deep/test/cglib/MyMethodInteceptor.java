package com.deep.test.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hudepin
 * @Description
 * @ClassName MyMethodInteceptor
 * @create_date 2020.07.31 11:05
 * @since 1.2.0
 */
public class MyMethodInteceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("这里是对目标类进行增强！！！");
        //注意这里的方法调用，不是用反射哦！！！
        Object object = methodProxy.invokeSuper(obj, args);
        return object;
    }
}
