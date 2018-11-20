package com.designPtn;

/**
 * 模板模式：
 * 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。
 *
 *
 * 模板方法模式适用场景
 1.一次性实现一个算法的不变的部分，并将可变的行为留给子类来实现。
 2.各子类中公共的行为应被提取出来并集中到一个公共父类中以避免代码重复。
    这是Opdyke和Johnson所描述过的“重分解以一般化”的一个很好的例子。
    首先识别现有代码中的不同之处，并且将不同之处分离为新的操作。
    最后，用一个调用这些新的操作的模板方法来替换这些不同的代码。
 3.控制子类扩展。模板方法只在特定点调用“hook”操作，这样就只允许在这些点进行扩展。
 * @author: yangmengjun
 * @date: 2018\11\20 0020 9:48
 */
public abstract class TemplatePattern {

    public abstract void start();

    public abstract void run();

    public void act(){
        start();
        run();
    }

    public static void main(String[] args) {
        TemplatePattern car = new Honda();
        car.act();

        TemplatePattern goodCar = new Byd();
        goodCar.act();
    }

}
class Honda extends TemplatePattern{

    @Override
    public void start() {
        System.out.println("本田启动");
    }

    @Override
    public void run() {
        System.out.println("本田开始跑了");
    }
}

class Byd extends TemplatePattern{

    @Override
    public void start() {
        System.out.println("牛逼的比亚迪启动");
    }

    @Override
    public void run() {
        System.out.println("牛逼的比亚迪开始跑了-----》");
    }
}