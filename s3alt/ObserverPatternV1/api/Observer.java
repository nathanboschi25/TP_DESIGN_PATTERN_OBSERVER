package s3alt.ObserverPatternV1.api;


public interface Observer {
    /**
     * Update the observer with the new state of the subject
     *
     * @param context the subject
     */
    void update(Subject context);
}
