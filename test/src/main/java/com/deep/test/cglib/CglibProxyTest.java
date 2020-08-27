package com.deep.test.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author hudepin
 * @Description
 * @ClassName CglibProxyTest
 * @create_date 2020.07.31 11:06
 * @since 1.2.0
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        //在指定目录下生成动态代理类，我们可以反编译看一下里面到底是一些什么东西
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\hudepin\\project\\test\\test");

        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Bean.class);
        enhancer.setCallback(new MyMethodInteceptor());
        Bean proxyBean =(Bean)enhancer.create();
        proxyBean.getName();
    }
}
