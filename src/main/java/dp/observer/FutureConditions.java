package dp.observer;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
public class FutureConditions implements Observer {
    private int temp;
    private int humidity;
    private int pressure;
    private Subject subject;

    public FutureConditions(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(int temp, int pressure, int humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    private void display() {
        System.out.println(" \n In future conditions ::  \n");
        System.out.println("temp  :: " + temp + " humidity  ::" + humidity + " pressure :: " + pressure);
    }
}
