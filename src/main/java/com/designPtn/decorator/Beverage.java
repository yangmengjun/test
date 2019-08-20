package com.designPtn.decorator;

/**
 * 饮料基类
 * 一个包含了cost的抽象方法的类
 */
public abstract class Beverage {
    String desc = "Unknow beverage";
    public String getDesc(){
        return desc;
    }

    /**
     * 基类的方法，子类必须实现
     * @return
     */
    public abstract float cost();
}
