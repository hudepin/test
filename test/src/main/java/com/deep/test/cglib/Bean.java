package com.deep.test.cglib;

/**
 * @author hudepin
 * @Description
 * @ClassName Bean
 * @create_date 2020.07.31 11:04
 * @since 1.2.0
 */
public class Bean {
    private String name;

    public String getName() {
        System.out.println("hudepin test");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String getAge(){
        return "123";
    }
}
