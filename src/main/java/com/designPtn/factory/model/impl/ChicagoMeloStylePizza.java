package com.designPtn.factory.model.impl;

import com.designPtn.factory.model.Pizza;

public class ChicagoMeloStylePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("芝加哥西瓜风味比萨准备中。。。");
    }

    @Override
    public void bake() {
        System.out.println("芝加哥西瓜风味比萨烘烤中。。。");
    }

    @Override
    public void cut() {
        System.out.println("芝加哥西瓜风味比萨切割中。。。");
    }

    @Override
    public void box() {
        System.out.println("芝加哥西瓜风味比萨打包中。。。");
    }

    @Override
    public void flavor() {
        System.out.println("芝加哥西瓜口味比萨");
    }
}
