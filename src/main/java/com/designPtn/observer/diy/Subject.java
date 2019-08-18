package com.designPtn.observer.diy;

import java.util.List;

/**
 * 观察者主题，与观察者是一对多的关系
 */
public interface Subject {

    public void register(Object obj);

    public void remove(Object obj);

    public List<Object> listObservers();

    public void notifyObservers();

}
