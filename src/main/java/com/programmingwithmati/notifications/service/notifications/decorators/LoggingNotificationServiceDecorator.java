package com.programmingwithmati.notifications.service.notifications.decorators;

import com.programmingwithmati.notifications.model.events.FlightEvent;
import com.programmingwithmati.notifications.service.Decorator;
import com.programmingwithmati.notifications.service.notifications.NotificationService;

public class LoggingNotificationServiceDecorator extends Decorator<NotificationService> implements NotificationService {

  public LoggingNotificationServiceDecorator(NotificationService target) {
    super(target);
  }

  @Override
  public void notifyUser(FlightEvent<?> event) {
    System.out.printf("INFO - Notifying user %s. Event Type: %s%n", event.userId(), event.type());
    target.notifyUser(event);
  }
}
