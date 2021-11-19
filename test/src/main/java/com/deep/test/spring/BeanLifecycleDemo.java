package com.deep.test.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author hudepin
 * @Description
 * @ClassName BeanLifecycleDemo
 * @create_date 2020.08.27 16:23
 * @since 1.2.0
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BeanLifecycleDemo implements DisposableBean, InitializingBean, BeanPostProcessor, ApplicationContextAware, ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware, BeanNameAware, EnvironmentAware,  ResourceLoaderAware {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanLifecycleDemo.class);
        context.refresh();
        context.close();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanLifecycleDemo destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanLifecycleDemo afterPropertiesSet...");
    }

    /**
     * 也可以通过xml 配置 destroy 方法
     */
    @PreDestroy
    public void destroy1() {
        System.out.println("BeanLifecycleDemo @PreDestroy...");
    }
    /**
     * 也可以通过xml 配置 init 方法
     */
    @PostConstruct
    public void init() {
        System.out.println("BeanLifecycleDemo @PostConstruct...");
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanLifecycleDemo postProcessBeforeInitialization...");
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanLifecycleDemo postProcessAfterInitialization...");
        return bean;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext:" + applicationContext);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("setApplicationEventPublisher:" + applicationEventPublisher);
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("setEnvironment:" + environment);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("setResourceLoader:" + resourceLoader);
    }


}
