package dp.observer.news;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public class Publisher implements PublisherInt {

    List<SubscriberInt> subscribers = new ArrayList<>();

    @Override
    public void registerSubscriber(SubscriberInt subscriberInt) {
        subscribers.add(subscriberInt);

    }

    @Override
    public void removeSubscriber(SubscriberInt subscriberInt) {
        subscribers.remove(subscriberInt);
    }

    @Override
    public void notifySubscriber() {

        for (SubscriberInt subscriberInt : subscribers) {
            subscriberInt.update("new update");
        }
    }

}
