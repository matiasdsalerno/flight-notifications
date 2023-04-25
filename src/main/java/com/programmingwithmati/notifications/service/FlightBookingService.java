package com.programmingwithmati.notifications.service;

import com.programmingwithmati.notifications.model.Flight;
import com.programmingwithmati.notifications.model.events.FlightBookedData;
import com.programmingwithmati.notifications.model.events.FlightEvent;
import com.programmingwithmati.notifications.service.notifications.NotificationService;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightBookingService {

  private final Map<String, NotificationService> eventSubscribers = new ConcurrentHashMap<>();
  private final Map<String, Flight> flights = Stream.of(
          new Flight("IB100", "EZE", LocalDateTime.now().plusDays(10),"LHR", LocalDateTime.now().plusDays(11)),
          new Flight("IB101", "MCR", LocalDateTime.now().plusDays(10),"MAD", LocalDateTime.now().plusDays(11))
  ).collect(Collectors.toMap(Flight::flightNumber, Function.identity()));

  public void bookFlight(
                         String userId,
                         String flightNumber) {
    // Business logic
    var id = UUID.randomUUID().toString();
    var bookingNumber = UUID.randomUUID().toString();
    var event = new FlightEvent<>(
            id,
            userId,
            LocalDateTime.now(),
            bookingNumber,
            flights.get(flightNumber),
            FlightEvent.Type.FLIGHT_BOOKED,
            new FlightBookedData(flightNumber, bookingNumber)
    );
    notifySubscribers(event);
  }

  private void notifySubscribers(FlightEvent<?> event) {
    eventSubscribers
            .forEach((s, notificationService) -> notificationService.notifyUser(event));
  }

  public void subscribe(String name, NotificationService service) {
    eventSubscribers.put(name, service);
  }
}
