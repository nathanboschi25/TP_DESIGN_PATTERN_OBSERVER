import s3alt.ObserverPatternV1.Subscriber;
import s3alt.ObserverPatternV1.Youtuber;

public class TestYoutubeV1 {
    public static void main(String[] args) {
        Subscriber jeanPhilippe = new Subscriber("Jean-Philippe");
        Subscriber jeanJacques = new Subscriber("Jean-Jacques");
        Subscriber jeanPierre = new Subscriber("Jean-Pierre");
        Subscriber jeanLuc = new Subscriber("Jean-Luc");


        Youtuber youtuber1 = new Youtuber("ytb1");
        youtuber1.subscribe(jeanPhilippe);
        youtuber1.subscribe(jeanLuc);
        youtuber1.subscribe(jeanPierre);

        Youtuber youtuber2 = new Youtuber("ytb2");
        youtuber2.subscribe(jeanJacques);
        youtuber2.subscribe(jeanLuc);

        Youtuber youtuber3 = new Youtuber("ytb3");
        youtuber3.subscribe(jeanJacques);
        youtuber3.subscribe(jeanPhilippe);
        youtuber3.subscribe(jeanPierre);


        youtuber1.uploadVideo("This single query costs $1,000,000 a month! ");
        youtuber2.uploadVideo("ChatGPT vient de se faire détrôner par des génies français ");

    }
}
