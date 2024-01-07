package s3alt.ObserverPatern;

import s3alt.ObserverPatern.api.Observer;
import s3alt.ObserverPatern.api.Subject;

public class Suscriber implements Observer {
    public String name;

    public Suscriber(String name){
        this.name = name;
    }

    @Override
    public void update(Subject state) {
        System.out.println("Hey " + this.name + " " + ((Youtuber) state).channelName + " just uploaded a new video!");
        System.out.println("Check it out: " + ((Youtuber) state).getLastVideo());
    }
}
