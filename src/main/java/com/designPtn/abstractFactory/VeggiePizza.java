package com.designPtn.abstractFactory;

public class VeggiePizza extends Pizza {

    PizzaIngredientFactory factory;

    /**
     * 要制作pizza需要工厂提供原料，所有的pizza都要从构造器中得到一个工厂并存储到实例变量中
     * @param factory
     */
    public VeggiePizza(PizzaIngredientFactory factory){
        this.factory = factory;
    }

    /**
     * 该方法按步骤执行比萨的创建
     */
    @Override
    void prepare() {
         sauce = factory.createeSauce();
         cheese = factory.createCheese();

    }
}
