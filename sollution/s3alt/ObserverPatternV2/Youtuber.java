package s3alt.ObserverPatternV2;

import s3alt.ObserverPatternV2.api.NotificationTypes;
import s3alt.ObserverPatternV2.api.Observer;
import s3alt.ObserverPatternV2.api.Subject;

import java.util.ArrayList;
import java.util.List;

public class Youtuber implements Subject {
    public List<Subscriber> subscribers;
    private String channelName;
    private String lastVideo;
    private boolean isLive;

    public Youtuber(String channelName) {
        this.channelName = channelName;
        subscribers = new ArrayList<>();
    }

    public void uploadVideo(String videoName) {
        this.lastVideo = videoName;
        notifyObservers(NotificationTypes.NEW_VIDEO);
    }

    public void goLive() {
        this.isLive = true;
        notifyObservers(NotificationTypes.LIVE_STARTED);
    }

    public void endLive() {
        this.isLive = false;
        notifyObservers(NotificationTypes.LIVE_ENDED);
    }

    public void renameChannel(String newName) {
        this.channelName = newName;
        notifyObservers(null);
    }

    public String getChannelName() {
        return channelName;
    }

    public String getLastVideo() {
        return lastVideo;
    }

    public boolean isLive() {
        return this.isLive;
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
    public void notifyObservers(NotificationTypes type) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(type, this);
        }
    }
}
