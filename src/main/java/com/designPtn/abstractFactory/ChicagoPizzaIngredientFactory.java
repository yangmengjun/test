package com.designPtn.abstractFactory;

import com.designPtn.abstractFactory.PizzaIngredientFactory;
import com.designPtn.factory.model.Cheese;
import com.designPtn.factory.model.Sauce;
import com.designPtn.factory.model.Viggies;
import com.designPtn.factory.model.impl.ChicagoSaltSauce;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Sauce createeSauce() {
        return new ChicagoSaltSauce();
    }

    @Override
    public Cheese createCheese() {

        return null;
    }

    @Override
    public Viggies createViggies() {
        //TODO 类似上面的
        return null;
    }
}
