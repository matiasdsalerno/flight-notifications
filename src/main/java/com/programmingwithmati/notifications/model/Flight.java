package com.programmingwithmati.notifications.model;

import java.time.LocalDateTime;

public record Flight(
        String flightNumber,
        String origin,
        LocalDateTime departureTime,
        String destination,
        LocalDateTime arrivalTime
) {
}
