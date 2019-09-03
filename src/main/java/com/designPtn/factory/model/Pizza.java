package com.designPtn.factory.model;

/**
 * 也可以是抽象类
 * Pizza 和PizzaStore工厂属于平级关系
 */

public interface Pizza {

    public void prepare();
    public void bake();
    public void cut();
    public void box();

    public void flavor();
}
