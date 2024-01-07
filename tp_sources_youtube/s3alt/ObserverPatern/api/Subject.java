package s3alt.ObserverPatern.api;

public interface Subject {
    void suscribe(Observer observer);
    void unsuscribe(Observer observer);
    void notifyObservers();
}