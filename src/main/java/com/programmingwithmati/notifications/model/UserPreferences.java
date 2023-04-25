package com.programmingwithmati.notifications.model;

import com.programmingwithmati.notifications.model.events.FlightEvent;

import java.util.List;

public record UserPreferences(
        List<FlightEvent.Type> eventsToNotify
) {
  public boolean satisfiesUserPreferences(FlightEvent<?> event) {
    return eventsToNotify.contains(event.type());
  }
}
