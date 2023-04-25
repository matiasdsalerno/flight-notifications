package com.programmingwithmati.notifications.service.notifications.decorators;

import com.programmingwithmati.notifications.model.events.FlightEvent;
import com.programmingwithmati.notifications.service.Decorator;
import com.programmingwithmati.notifications.model.UserPreferences;
import com.programmingwithmati.notifications.service.notifications.NotificationService;

import java.util.List;
import java.util.Map;

public class UserPreferencesNotificationServiceDecorator extends Decorator<NotificationService> implements NotificationService {

  private final Map<String, UserPreferences> userPreferences = Map.of(
          "1", new UserPreferences(List.of(FlightEvent.Type.FLIGHT_BOOKED, FlightEvent.Type.FLIGHT_DELAYED)),
          "2", new UserPreferences(List.of(FlightEvent.Type.FLIGHT_DELAYED))
  );
  public UserPreferencesNotificationServiceDecorator(NotificationService target) {
    super(target);
  }

  @Override
  public void notifyUser(FlightEvent<?> event) {
    if (!satisfiesUserPreferences(event)) {
      System.out.println("Skipping notification. User preferences don't match.");
      return;
    }

    target.notifyUser(event);

  }

  private boolean satisfiesUserPreferences(FlightEvent<?> event) {
    return userPreferences.get(event.userId())
            .satisfiesUserPreferences(event);
  }

}
