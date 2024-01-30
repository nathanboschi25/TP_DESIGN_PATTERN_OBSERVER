package s3alt.ObserverPatternV3;

import s3alt.ObserverPatternV3.api.NotificationTypes;
import s3alt.ObserverPatternV3.api.Observer;
import s3alt.ObserverPatternV3.api.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Youtuber implements Subject {
    public Map<Subscriber, List<NotificationTypes>> subscribers;
    private String channelName;
    private String lastVideo;
    private boolean isLive;

    public Youtuber(String channelName) {
        this.channelName = channelName;
        subscribers = new HashMap<>();
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
    public void subscribe(Observer observer, List<NotificationTypes> types) {
        if (!subscribers.containsKey(observer)) {
            subscribers.put((Subscriber) observer, types);
        } else {
            subscribers.get(observer).addAll(types);
        }
    }

    @Override
    public void unsubscribe(Observer observer, List<NotificationTypes> types) {
        if (types == null) {
            subscribers.remove(observer);
            return;
        }
        if (subscribers.containsKey(observer)) {
            subscribers.get(observer).removeAll(types);
        }
    }

    @Override
    public void notifyObservers(NotificationTypes type) {
        for (Subscriber subscriber : subscribers.keySet()) {
            List<NotificationTypes> suscriberNotificationList = subscribers.get(subscriber);
            if (suscriberNotificationList == null || suscriberNotificationList.contains(type) || type == null) {
                subscriber.update(type, this);
            }
        }
    }
}
