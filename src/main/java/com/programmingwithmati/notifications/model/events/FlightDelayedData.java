package com.programmingwithmati.notifications.model.events;

import java.time.LocalDateTime;

public record FlightDelayedData(
        LocalDateTime newDepartureTime,
        LocalDateTime newArrivalTime
) {
}
