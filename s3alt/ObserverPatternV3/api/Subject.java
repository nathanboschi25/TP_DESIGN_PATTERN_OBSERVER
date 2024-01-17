package s3alt.ObserverPatternV3.api;

import java.util.List;

public interface Subject {
    default void subscribe(Observer observer) {
        subscribe(observer, null);
    }

    void subscribe(Observer observer, List<NotificationTypes> types);

    default void unsubscribe(Observer observer) {
        unsubscribe(observer, null);
    }

    void unsubscribe(Observer observer, List<NotificationTypes> types);

    default void notifyObservers() {
        notifyObservers(null);
    }

    void notifyObservers(NotificationTypes type);
}