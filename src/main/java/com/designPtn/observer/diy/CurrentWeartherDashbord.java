package com.designPtn.observer.diy;


import com.designPtn.observer.DisplayElement;
import lombok.extern.slf4j.Slf4j;

/**
 * 展示当前温度的布告板，其中观察者
 */
@Slf4j
public class CurrentWeartherDashbord implements Observer,DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;

    private WeatherData weatherData;

    public CurrentWeartherDashbord(){}

    public CurrentWeartherDashbord(WeatherData weatherData){
        this.weatherData = weatherData;
    }


    @Override
    public void display() {
        System.out.println(String.format("当前温度：%f,当前湿度：%f,当前气压:%f",temperature,humidity,pressure));
    }

    @Override
    public void update(float temp, float humility, float pressure) {
        this.temperature = temp;
        this.humidity = humility;
        this.pressure = pressure;
        display();
    }

    private void cancelResigster(){
        weatherData.remove(this);
    }
}
