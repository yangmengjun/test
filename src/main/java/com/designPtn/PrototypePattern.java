package com.designPtn;


import lombok.Data;

/**
 * 原型模式
 *   是基于对象的拷贝的，可以是浅拷贝也可以是深拷贝操作。
 *   也就是说当我们需要批量生成某一对象，就可以事先创建一个对象的原型，再通过对象的拷贝操作批量生成对象。
 * @author: yangmengjun
 * @date: 2018\11\20 0020 15:06
 */
public class PrototypePattern {
    public static void main(String[] args) {
        int times = 1000000000;
        AbstractSpoon spoon = new SoupSpoon();
        long begin = System.currentTimeMillis();
        for (int i=0;i<times;i++){
            spoon.clone();
        }
        long end = System.currentTimeMillis();
        System.out.println("原型模式耗时："+(end-begin));
    }

}
@Data
abstract class AbstractSpoon implements Cloneable{
    String spoonName;

    @Override
    public Object clone(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
class SoupSpoon extends AbstractSpoon{
    public SoupSpoon(){
        setSpoonName("Soup spoon");
    }
}