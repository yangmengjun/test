package com.designPtn.observer.diy;

/**
 * 所有的观察者都要实现这个具有唯一的update方法的接口用于接受数据的变化
 */
public interface Observer {
    public void update(float temp,float humility,float pressure);
}
