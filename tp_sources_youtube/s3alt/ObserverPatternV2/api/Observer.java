package s3alt.ObserverPatternV2.api;

public interface Observer {
    default void update(Subject context) {
        update(null, context);
    }

    void update(NotificationTypes type, Subject context);
}
