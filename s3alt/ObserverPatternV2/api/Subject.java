package s3alt.ObserverPatternV2.api;

public interface Subject {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    default void notifyObservers() {
        notifyObservers(null);
    }

    void notifyObservers(NotificationTypes type);
}