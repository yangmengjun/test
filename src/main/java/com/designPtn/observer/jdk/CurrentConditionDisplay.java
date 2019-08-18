package com.designPtn.observer.jdk;

import com.designPtn.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * 使用jdk的包实现观察者模式
 */
public class CurrentConditionDisplay implements Observer,DisplayElement {

    Observable observable;

    private float temprature;
    private float humidity;

    public CurrentConditionDisplay(){}

    public CurrentConditionDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        System.out.println(temprature+ ""+humidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherDataJDK){
            WeatherDataJDK weatherDataJDK = (WeatherDataJDK)o;
            this.temprature = weatherDataJDK.getTemperature();
            this.humidity = weatherDataJDK.getHumidity();
        }
    }
}
