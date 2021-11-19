package com.deep.test.jdk8;

/**
 * @author hudepin
 * @Description FunctionalInterface 函数式接口 必须只能有一个抽象方法
 * @ClassName FunctionInterfaceTest
 * @create_date 2020.09.10 14:54
 * @since 1.2.0
 */
@FunctionalInterface
public interface FunctionInterfaceTest {
    public abstract int abstractMethod(int a,int b);
    //静态方法
    public static void staticMethod(){

    }
//    //default 方法不是抽象方法
//    public default void defaultMethod(){
//
//    }
    //Object 类方法不属于抽象方法
    public boolean equals(Object obj);
}
