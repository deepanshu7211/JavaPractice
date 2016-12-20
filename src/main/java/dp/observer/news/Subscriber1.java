package dp.observer.news;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public class Subscriber1 implements SubscriberInt {
    @Override
    public void update(String string) {
        System.out.println("New Edition from subscriber1  " + string);
    }
}
