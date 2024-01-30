package s3alt.ObserverPatternV1;

import s3alt.ObserverPatternV1.api.Observer;
import s3alt.ObserverPatternV1.api.Subject;

public class Subscriber implements Observer {
    public String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject context) {
        System.out.println("Hey " + this.name + " " + ((Youtuber) context).channelName + " just uploaded a new video!");
        System.out.println("Check it out: " + ((Youtuber) context).getLastVideo());
    }
}
