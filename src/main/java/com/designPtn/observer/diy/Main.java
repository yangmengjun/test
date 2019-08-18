package com.designPtn.observer.diy;

public class Main {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentWeartherDashbord currentWeartherDashbord = new CurrentWeartherDashbord();
        weatherData.register(currentWeartherDashbord);
        ForeCastWeartherDashbord foreCastWeartherDashbord = new ForeCastWeartherDashbord();
        weatherData.register(foreCastWeartherDashbord);
        weatherData.notifyObservers();

        weatherData.setMeasuerment(22,43,45);
        weatherData.setMeasuerment(10,15,100);


    }
}
