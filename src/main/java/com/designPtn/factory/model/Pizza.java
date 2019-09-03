package com.designPtn.factory.model;

/**
 * 也可以是抽象类
 * Pizza 和PizzaStore工厂属于平级关系
 */

public abstract class Pizza {

    String name;

    public abstract void prepare();
    public abstract void bake();
    public abstract void cut();
    public abstract void box();

    public abstract void flavor();
}
