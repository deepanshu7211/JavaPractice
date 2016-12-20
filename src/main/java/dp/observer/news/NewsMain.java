package dp.observer.news;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public class NewsMain {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.registerSubscriber(new Subscriber1());
        publisher.registerSubscriber(new Subscriber2());

        publisher.notifySubscriber();
    }
}
