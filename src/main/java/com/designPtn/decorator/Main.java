package com.designPtn.decorator;

public class Main {
    public static void main(String[] args) {
        //1.来一杯压缩咖啡，不需要加调料
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDesc()+" $"+beverage.cost());

        //2.来一份深焙双份摩卡
        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDesc()+" $"+beverage1.cost());

    }
}
