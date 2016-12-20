package dp.observer.news;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public interface PublisherInt {
    void registerSubscriber(SubscriberInt subscriberInt);

    void removeSubscriber(SubscriberInt subscriberInt);

    void notifySubscriber();
}
