package com.designPtn.observer.jdk;

import java.util.Observable;

/**
 * jdk包是实现的观察者模式
 * 1.继承Observable类
 * 2.观察者实现Observer接口
 */
public class WeatherDataJDK extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataJDK(){

    }

    public void measurementChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasuerment(float temp, float humility, float pressure) {
        this.temperature = temp;
        this.humidity = humility;
        this.pressure = pressure;
        measurementChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

