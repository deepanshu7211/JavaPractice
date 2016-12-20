package dp.observer;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
public class CurrentConditions implements Observer {
    private int temp;
    private int humidity;
    private int pressure;
    private Subject subject;

    public CurrentConditions(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(int temp, int pressure, int humidity) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();

    }

    public void display() {
        System.out.println(" \n Current Conditions :: \n");
        System.out.println(" temp :: " + temp + " humidity :: " + humidity + " pressure :: " + pressure);
    }


}
