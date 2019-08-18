package com.designPtn.observer.jdk;

public class Main {

    public static void main(String[] args) {

        WeatherDataJDK weatherDataJDK = new WeatherDataJDK();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay();
        weatherDataJDK.addObserver(currentConditionDisplay);
        weatherDataJDK.setMeasuerment(1,24,4);
    }

}
