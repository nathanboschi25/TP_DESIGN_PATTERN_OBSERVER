package s3alt.ObserverPatern;

import s3alt.ObserverPatern.api.Observer;
import s3alt.ObserverPatern.api.Subject;

import java.util.ArrayList;
import java.util.List;

public class Youtuber implements Subject {
    public String channelName;
    public List<Suscriber> suscribers;
    private String lastVideo;

    public Youtuber(String channelName){
        this.channelName = channelName;
        suscribers = new ArrayList<>();
    }

    public String getLastVideo() {
        return lastVideo;
    }

    public void uploadVideo(String videoName){
        this.lastVideo = videoName;
        notifyObservers();
    }

    @Override
    public void suscribe(Observer observer) {
        this.suscribers.add((Suscriber) observer);
    }

    @Override
    public void unsuscribe(Observer observer) {
        this.suscribers.remove((Suscriber) observer);
    }

    @Override
    public void notifyObservers() {
        for (Suscriber suscriber : suscribers) {
            suscriber.update(this);
        }
    }
}
