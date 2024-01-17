# Observer Pattern Lab

## Introduction

You're working for Google and you have to implement the notification system for YouTube. You can download 'basic
sources' with the following command:
```shell
git clone https://github.com/nathanboschi25/TP_DESIGN_PATTERN_OBSERVER.git
```

## Version 1 - Basic

The basic idea is that a user (`Subscrber` -> `Observer`) can subscribe to a channel (`Youtuber` -> `Subject`) and
receive notifications when a new video is uploaded.
**Foreach notification, the Subscriber prints his name and the notification.**

**Texts below are not exhaustive, fields and methods developed below are those which deserve to be detailed. To complete
the lab in full, refer to the UML diagram at the end of this section.**

### Suscriber

- `update(Youtuber context)` : the action to do when the `Subject` notifies the `Observer`. In this case, the name of
  the video is
  printed.

### Youtuber

- `lastVideo` : the name of the last video uploaded
- `suscribers` : the list of `Observers` that subscribed to the `Subject`. It is a list of `Subscriber`.
- `subscribe(Subscriber subscriber)` and `unsubscribe(Subscriber subscriber)` : add or remove a `Subscriber` from the
  subscribers list.
- `notifyObservers()` : notify all the subscribers that a new video has been uploaded. It calls the `update()` method of
  each
  `Subscriber`.
- `uploadVideo(String videoName)` : upload a new video and notify all the subscribers.

Here is the UML diagram of the first version:
![UML](./s3alt/ObserverPatternV1/package.png)

## Version 2 - Notification types

In this version, we want to be able to emit different types of notifications. Foreach notification, this step would
allow us to make different actions depending on the type of notification.

**Texts below are not exhaustive, fields and methods developed below are those which deserve to be detailed. To complete
the lab in full, refer to the UML diagram at the end of this section.**

### NotificationTypes

`NEW_VIDEO`, `LIVE_STARTED`, `LIVE_ENDED` are the different types of notifications that we can emit in this example.

**You need to update the `Suscriber::update()`, `Youtuber::notifyObservers()` and `Youtuber::uploadVideo()` methods to
take into account the notification type.**

### Youtuber

- `isLive` : a boolean that indicates if the youtuber is currently live or not.
- `goLive()` and `endLive()` : methods to start and end a live. They notify the subscribers that the youtuber is live or
  not.
- `notifyObservers(NotificationTypes notificationType)` : notify all the subscribers that a new video has been uploaded.
  It calls the `update()` method of each
  `Subscriber` with the notification type as parameter.

### Suscriber

- `update(Youtuber context, NotificationTypes notificationType)` : the action to do when the `Subject` notifies
  the `Observer`. You need to differentiate the actions depending on the notification type (e.g. print the name of the
  video if the notification type is `NEW_VIDEO` and print "The youtuber {name} is live" if the notification type
  is `LIVE_STARTED`...)

Here is the UML diagram of the second version:
![UML](./s3alt/ObserverPatternV2/package.png)

## Version 3 - Notification types selection

In this version, we want to be able to subscribe to different types of notifications. Foreach notification, this step
would allow us to make different actions depending on the type of notification and send only the notifications that the
subscriber wants to receive.
This version force us to change the `suscribers` list of the `Youtuber` class. It is now a
map : `Map<Suscriber, List<NotificationTypes>>`.

**Texts below are not exhaustive, fields and methods developed below are those which deserve to be detailed. To complete
the lab in full, refer to the UML diagram at the end of this section.**

### Youtuber

- `subscribe(Subscriber subscriber, List<NotificationTypes> notificationTypes)` : add a `Subscriber` to the subscribers
  list **with the list of notification types that he wants to receive**.
- `notifyObservers(NotificationTypes notificationType)` : notify all the subscribers that a new video has been uploaded.
  It calls the `update()` method of each
  `Subscriber` with the notification type as parameter. **You need to check if the subscriber wants to receive this
  notification type.**'

Here is the UML diagram of the third version:
![UML](./s3alt/ObserverPatternV3/package.png)

