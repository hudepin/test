package com.deep.test.jdk8;

/**
 * @author hudepin
 * @Description
 * @ClassName FunctionImpl
 * @create_date 2020.09.10 14:58
 * @since 1.2.0
 */
public class FunctionImpl implements FunctionInterfaceTest {


    @Override
    public int abstractMethod(int a, int b) {
        return a+b;
    }

}
