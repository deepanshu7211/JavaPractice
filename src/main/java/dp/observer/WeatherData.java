package dp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
public class WeatherData implements Subject {
    private List<Observer> observerList;
    private int temp;
    private int humidity;
    private int pressure;

    public WeatherData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observerList.indexOf(observer);
        if (i >= 0) {
            observerList.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observerList.size(); i++) {
            Observer observer = observerList.get(i);
            observer.update(temp, humidity, pressure);
        }
    }

    public void measurementChange() {
        notifyObserver();
    }

    public void setMeasurement(int temp, int humidity, int pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChange();
    }
}
