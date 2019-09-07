package com.designPtn.singleton;

/**
 * 该方式优点：使用的时候才会初始化（延迟加载）
 *       缺点：已经实例化之后，多线程查询会造成性能瓶颈
 */
class SingleTon2 {
    public static SingleTon2 instance = null;

    public static synchronized SingleTon2 getInstance() {
        if (instance == null) {
            return new SingleTon2();
        }
        return instance;
    }
}