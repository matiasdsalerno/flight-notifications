package com.programmingwithmati.notifications.service.notifications;

import com.programmingwithmati.notifications.model.events.FlightEvent;

public interface NotificationService {

  void notifyUser(FlightEvent<?> event);

}
