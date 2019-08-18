package com.designPtn.observer.jdk;

import com.designPtn.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer,DisplayElement {
    private float currentPressure = 33.22f;
    private float lastPressutre;

    Observable observable;



    public ForecastDisplay(){}

    public ForecastDisplay(Observable observable){
        this.observable = observable;

    }

    @Override
    public void update(Observable o, Object arg) {
        if(observable instanceof WeatherDataJDK){
            WeatherDataJDK weatherDataJDK = (WeatherDataJDK) observable;
            weatherDataJDK.addObserver(this);
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("當前氣壓："+currentPressure+" 預測氣壓"+lastPressutre);
    }
}
