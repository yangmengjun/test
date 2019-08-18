package com.designPtn.observer.diy;

import java.util.List;

public class WeatherData implements Subject {

    private  List<Object> objs;

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void register(Object obj) {
        objs.add(obj);
    }

    @Override
    public void remove(Object obj) {
        int index  = objs.indexOf(obj);
        if(index>-1){
            objs.remove(obj);
        }
    }

    @Override
    public List<Object> listObservers() {
        return objs;
    }

    public void measurementChanged(){
        notifyObservers();
    }

    /**
     * 次方法一般是给第三方调用的
     * @param temp
     * @param humility
     * @param pressure
     */
    public void setMeasuerment(float temp, float humility, float pressure) {
        this.temperature = temp;
        this.humidity = humility;
        this.pressure = pressure;
        measurementChanged();
    }

    @Override
    public void notifyObservers() {
        for(Object object:objs){
            Observer observer = (Observer)object;
            observer.update(temperature,humidity,pressure);
        }
    }
}
