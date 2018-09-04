package com.lamda.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author: yangmengjun
 * @date: 2018\8\31 0031 17:40
 */
@NoArgsConstructor
@AllArgsConstructor
public class Person{
    private int id;
    private  String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}