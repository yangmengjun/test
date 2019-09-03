package com.designPtn.abstractFactory;

import com.designPtn.factory.model.Cheese;
import com.designPtn.factory.model.Sauce;
import lombok.Data;

@Data
public abstract class Pizza {
    String name;
    Sauce sauce;
    Cheese cheese;

    /**
     * 这个抽象方法用来手机比萨所需的原料（来自原料工厂）
     */
    abstract void prepare();


    void bake(){
        System.out.println("Bake for 20 minites");
    }

    void cut(){
        System.out.println();
    }

    void box(){
        System.out.println("Boxing pizza");
    }

}
