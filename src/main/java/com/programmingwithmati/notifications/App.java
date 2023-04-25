package com.programmingwithmati.notifications;

import com.programmingwithmati.notifications.service.*;
import com.programmingwithmati.notifications.service.notifications.EmailNotificationService;
import com.programmingwithmati.notifications.service.notifications.SmsNotificationService;
import com.programmingwithmati.notifications.service.notifications.decorators.LoggingNotificationServiceDecorator;
import com.programmingwithmati.notifications.service.notifications.decorators.UserPreferencesNotificationServiceDecorator;

import java.util.Map;

public class App {

  public static void main(String[] args) {

    var emailNotificationService = new LoggingNotificationServiceDecorator(new EmailNotificationService());
    var smsNotificationService = new LoggingNotificationServiceDecorator(new UserPreferencesNotificationServiceDecorator(new SmsNotificationService()));

    var flightBookingService = new FlightBookingService();

    Map.of(
            "emails", emailNotificationService,
            "sms", smsNotificationService
    ).forEach(flightBookingService::subscribe);

    System.out.println("User 1 booking");
    flightBookingService.bookFlight("1", "IB100");
    System.out.println("User 2 booking");
    flightBookingService.bookFlight("2", "IB101");
  }
}
