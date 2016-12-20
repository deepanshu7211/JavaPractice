package dp.observer;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
public class WeatherStationMain {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditions currentConditions = new CurrentConditions(weatherData);
//      weatherData.setMeasurement(35,45,45);

        FutureConditions futureConditions = new FutureConditions(weatherData);
        weatherData.setMeasurement(34, 44, 55);


    }
}
