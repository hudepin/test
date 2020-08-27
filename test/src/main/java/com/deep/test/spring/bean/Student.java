package com.deep.test.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hudepin
 * @Description
 * @ClassName Student
 * @create_date 2020.08.26 13:55
 * @since 1.2.0
 */
public class Student {
    private Long id;
    private String name;
    private int age;
    @Autowired
    private ClassRoom classRoom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classRoom.name=" + classRoom.getName() +
                '}';
    }
}
