package com.designPtn.abstractFactory;


public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory factory = new NYPizzaIngredientFactory();
        if(type.equals("cheese")){
            pizza = new CheesePizza(factory);
        }else if(type.equals("veggie")){
            pizza = new VeggiePizza(factory);
        }
        return pizza;
    }
}
