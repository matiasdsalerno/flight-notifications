package com.programmingwithmati.notifications.service.notifications;

import com.programmingwithmati.notifications.model.events.FlightEvent;

public class SmsNotificationService implements NotificationService {
  @Override
  public void notifyUser(FlightEvent<?> event) {
    System.out.printf("SMS Sent %s%n", event);
  }
}
