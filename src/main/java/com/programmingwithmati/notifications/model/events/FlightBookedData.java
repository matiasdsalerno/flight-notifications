package com.programmingwithmati.notifications.model.events;

import java.time.LocalDateTime;

public record FlightBookedData(
        String flightNumber,
        String bookingNumber
) {
}
