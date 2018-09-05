package com.lamda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yangmengjun
 * @date: 2018\8\31 0031 17:40
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person{
    private int id;
    private String name;
    private Integer score;
    private Boolean isPretty;

}