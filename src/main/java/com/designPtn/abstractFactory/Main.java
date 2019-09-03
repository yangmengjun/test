package com.designPtn.abstractFactory;

/**
 * 1.所有的方法尽可能抽象
 * 2.所有的model尽可能抽象（依赖具体情况）
 * 3.抽象工厂把
 */
public class Main {
    public static void main(String[] args) {
        PizzaStore store = new NYPizzaStore();
        store.orderPizza("cheese");
        Pizza cheese = store.createPizza("cheese");
        cheese.prepare();
    }
}
