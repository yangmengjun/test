package com.designPtn.abstractFactory;

public class Main {
    public static void main(String[] args) {
        PizzaStore store = new NYPizzaStore();
        store.orderPizza("cheese");
        Pizza cheese = store.createPizza("cheese");
        cheese.prepare();
    }
}
