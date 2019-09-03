package com.designPtn.abstractFactory;

import com.designPtn.factory.model.Cheese;
import com.designPtn.factory.model.Sauce;
import com.designPtn.factory.model.Viggies;

public interface PizzaIngredientFactory {
    public Sauce createeSauce();

    public Cheese createCheese();

    public Viggies createViggies();
}
