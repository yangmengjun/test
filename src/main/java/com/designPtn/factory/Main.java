package com.designPtn.factory;

import com.designPtn.factory.model.Pizza;

public class Main {
    public static void main(String[] args) {
        PizzaStore store = new NYPizzaStore();
        //1.下单
        Pizza pizza = store.orderPizza("apple");//orderPizza()方法本身并不知道具体的是哪种pizza
        //2.制作并打包pizza
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();


        PizzaStore store1 = new ChicagoPizzaStore();
        //1.下单
        Pizza pizza1 = store1.orderPizza("melo");
        //2.制作并打包pizza
        pizza1.prepare();
        pizza1.bake();
        pizza1.cut();
        pizza1.box();
    }
}
