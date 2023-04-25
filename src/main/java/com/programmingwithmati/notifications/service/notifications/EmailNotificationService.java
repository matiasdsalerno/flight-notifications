package com.programmingwithmati.notifications.service.notifications;

import com.programmingwithmati.notifications.model.events.FlightEvent;

public class EmailNotificationService implements NotificationService {
  @Override
  public void notifyUser(FlightEvent<?> event) {
    System.out.printf("Email sent %s%n", event);
  }
}
