package com.designPtn.decorator;

/**
 * 深焙
 */
public class DarkRoast extends CondimentDecorator{
    public DarkRoast(){
        desc = "DarkRoast";
    }

    Beverage beverage;
    public DarkRoast(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDesc() {
        return beverage.getDesc()+",DarkRoast";
    }

    @Override
    public float cost() {
        return 0.2f+beverage.cost();
    }
}
