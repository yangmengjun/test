package com.designPtn.decorator;

/**
 * 摩卡咖啡
 * 具体的装饰者
 */
public class Mocha extends CondimentDecorator{
    /**
     * 被装饰者对象
     */
    private Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDesc() {
        return beverage.getDesc()+",Mocha";
    }

    @Override
    public float cost() {
        return 0.30f+beverage.cost();
    }
}
