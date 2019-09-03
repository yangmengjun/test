package com.designPtn.factory;

import com.designPtn.factory.model.impl.ChicagoMeloStylePizza;
import com.designPtn.factory.model.impl.ChicagoVeggieStylePizza;
import com.designPtn.factory.model.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if ("melo".equals(type)) {
            return new ChicagoMeloStylePizza();
        }else if("veggie".equals(type)){
            return new ChicagoVeggieStylePizza();
        }
        return null;
    }
}
