package s3alt.ObserverPatternV1.api;

public interface Subject {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers();
}