package s3alt.ObserverPatternV3;

import s3alt.ObserverPatternV3.api.NotificationTypes;
import s3alt.ObserverPatternV3.api.Observer;
import s3alt.ObserverPatternV3.api.Subject;

public class Subscriber implements Observer {
    public String name;

    public Subscriber(String name) {
        this.name = name;
    }


    @Override
    public void update(NotificationTypes type, Subject context) {
        String message;
        switch (type) {
            case NEW_VIDEO ->
                    message = ((Youtuber) context).getChannelName() + " released a new video (" + ((Youtuber) context).getLastVideo() + "), go watch it";
            case LIVE_STARTED -> message = ((Youtuber) context).getChannelName() + " is now LIVE!";
            case LIVE_ENDED -> message = ((Youtuber) context).getChannelName() + " is no longer LIVE.";
            case null, default -> message = ((Youtuber) context).getChannelName() + " : channel updated!";
        }
        System.out.println(this.name + " -> " + message);
    }
}
