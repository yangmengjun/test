package com.designPtn.decorator;

/**
 *浓缩咖啡
 */
public class Espresso extends Beverage{

    public Espresso(){
        desc = "Espresso";
    }

    @Override
    public float cost() {
        return 2.1f;
    }
}
