package com.designPtn.factory;

import com.designPtn.factory.model.Pizza;

/**
 * 抽象工厂
 * 核心
 *
 * abstract Product factoryMethod(String type)
 * 1.工厂方法是抽象的，依赖子类处理对象的创建
 * 2.工厂方法必必须返回一个产品，超类中定义的方法，通常使用到工厂返回的值
 * 3.工厂方法必须将客户（超类中的代码，如orderPizza()）和具体产品的代码分隔开
 * 4.工厂方法需要参数（type，也可以不需要）来指定所要的产品
 *
 * 抽象的比萨商店类
 * 1.制作比萨（抽象方法）
 * 2.订比萨（交给抽象的Pizza子类去做，PizzaStore本身不知道谁做了，这就做到了解耦）
 * 将通用的比萨订作方法通过抽象来实现（下面的orderPizza方法），而具体的制作比萨的过程交给子类去实现
 */
public abstract class PizzaStore {

    /**
     * 超类PizzaStore并不知道有这个具体的类是哪一个，只知道所有的pizza都可以被制作、打包、切割和烘烤
     * @param type
     * @return
     */
    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.bake();
        return pizza;
    }

    /**
     * 创建比萨的抽象方法，子类必须实现（允许子类做决定）
     */
    protected abstract Pizza createPizza(String type);
}
