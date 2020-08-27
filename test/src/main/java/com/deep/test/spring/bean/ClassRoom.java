package com.deep.test.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hudepin
 * @Description
 * @ClassName ClassRoom
 * @create_date 2020.08.26 13:56
 * @since 1.2.0
 */
public class ClassRoom {
    private Long id;
    private String name;
    @Autowired
    private List<Student> students;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students.size() +
                '}';
    }
}
