package com.designPtn.factory;

import com.designPtn.factory.model.impl.NYStyleApplePizza;
import com.designPtn.factory.model.impl.NYStyleCheesePizza;
import com.designPtn.factory.model.Pizza;

/**
 * 超类PizzaStore并不知道有这个具体的类是哪一个，只知道所有的pizza都可以被制作、打包、切割和烘烤
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if("apple".equals(type)){
            return new NYStyleApplePizza();
        }else if("cheese".equals(type)){
            return new NYStyleCheesePizza();
        }
        return null;
    }
}
