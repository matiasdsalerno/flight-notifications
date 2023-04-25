package com.programmingwithmati.notifications.model.events;

import com.programmingwithmati.notifications.model.Flight;

import java.time.LocalDateTime;

public record FlightEvent<T>(
        String id,
        String userId,
        LocalDateTime timestamp,
        String bookingNumber,
        Flight flight,
        Type type,
        T data
) {

  public enum Type {
    FLIGHT_BOOKED,
    FLIGHT_DELAYED,
    FLIGHT_CHECKIN_AVAILABLE
  }
}
