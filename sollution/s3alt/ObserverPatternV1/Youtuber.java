package s3alt.ObserverPatternV1;

import s3alt.ObserverPatternV1.api.Observer;
import s3alt.ObserverPatternV1.api.Subject;

import java.util.ArrayList;
import java.util.List;

public class Youtuber implements Subject {
    public String channelName;
    public List<Subscriber> subscribers;
    // VIDEOS
    private String lastVideo;

    public Youtuber(String channelName) {
        this.channelName = channelName;
        subscribers = new ArrayList<>();
    }

    public void uploadVideo(String videoName) {
        this.lastVideo = videoName;
        notifyObservers();
    }

    public String getLastVideo() {
        return lastVideo;
    }


    @Override
    public void subscribe(Observer observer) {
        this.subscribers.add((Subscriber) observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.subscribers.remove((Subscriber) observer);
    }

    @Override
    public void notifyObservers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(this);
        }
    }
}
