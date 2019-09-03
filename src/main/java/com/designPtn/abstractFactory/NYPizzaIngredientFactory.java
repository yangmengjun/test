package com.designPtn.abstractFactory;

import com.designPtn.abstractFactory.PizzaIngredientFactory;
import com.designPtn.factory.model.Cheese;
import com.designPtn.factory.model.Sauce;
import com.designPtn.factory.model.Viggies;
import com.designPtn.factory.model.impl.NYAppleSauce;
import com.designPtn.factory.model.impl.NYReggianoCheese;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Sauce createeSauce() {
        return new NYAppleSauce();
    }

    @Override
    public Cheese createCheese() {
        return new NYReggianoCheese();
    }

    @Override
    public Viggies createViggies() {
        //TODO 类似上面的
        return null;
    }
}
