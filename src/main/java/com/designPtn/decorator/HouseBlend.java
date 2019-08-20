package com.designPtn.decorator;

/**
 * 综合咖啡
 */
public class HouseBlend extends Beverage {
    public HouseBlend(){
        desc = "House Blend Coffee";
    }
    @Override
    public float cost() {
        return 0.89f;
    }
}
