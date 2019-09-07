package com.designPtn.singleton;
/**
 * 单例模式
 * 1.确保只有一个实例
 * 2.只有一个全局访问点
 * @author Json
 *
 *
 * 下面的SingleTon（饱汉式）
 *     优点：多线程访问不会造成阻塞（性能困扰）
 *     缺点：启动就必须加载对象的实例
 *
 * 下面的SingleTon2（饿汉式）
 *     优点：使用的时候才会初始化（延迟加载）
 *     缺点：已经实例化之后，多线程查询会造成性能瓶颈
 *
 *  综合这两种，可使用 双重检查加锁 的方式，请看SingleTonDoubleCheck
 */

public class SingleTon {
    private final static SingleTon instance = new SingleTon();

    /**
     * 私有构造方法，保证不直接被实例化
     */
    private SingleTon() {

    }

    public SingleTon getInstance() {
        return instance;
    }
}

