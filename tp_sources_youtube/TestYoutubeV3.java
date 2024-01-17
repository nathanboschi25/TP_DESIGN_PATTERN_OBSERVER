import s3alt.ObserverPatternV3.Subscriber;
import s3alt.ObserverPatternV3.Youtuber;
import s3alt.ObserverPatternV3.api.NotificationTypes;

import java.util.List;

public class TestYoutubeV3 {
    public static void main(String[] args) {
        Subscriber jeanPhilippe = new Subscriber("Jean-Philippe");
        Subscriber jeanPierre = new Subscriber("Jean-Pierre");
        Subscriber jeanLuc = new Subscriber("Jean-Luc");


        Youtuber youtuber1 = new Youtuber("ytb1");
        youtuber1.subscribe(jeanPhilippe);
        youtuber1.subscribe(jeanLuc, List.of(NotificationTypes.NEW_VIDEO, NotificationTypes.LIVE_STARTED));
        youtuber1.subscribe(jeanPierre, List.of(NotificationTypes.LIVE_ENDED));


        youtuber1.uploadVideo("This single query costs $1,000,000 a month! ");
        youtuber1.goLive();
        youtuber1.endLive();
    }
}
