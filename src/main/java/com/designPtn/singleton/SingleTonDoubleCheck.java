package com.designPtn.singleton;

/**
 * 双重检查加锁的单例模式
 */
public class SingleTonDoubleCheck {

    /**
     * 使用volatile关键字，多线程访问保证可见性
     */
    private volatile static SingleTonDoubleCheck uniqueSingleton;

    private SingleTonDoubleCheck(){}

    public SingleTonDoubleCheck getUniqueSingleton(){
        //不存在再进入同步区，而不是像SingleTon2那样每次都进去同步区
        if(uniqueSingleton==null){
            synchronized (SingleTonDoubleCheck.class){
                uniqueSingleton = new SingleTonDoubleCheck();
            }
        }
        return uniqueSingleton;
    }

}
