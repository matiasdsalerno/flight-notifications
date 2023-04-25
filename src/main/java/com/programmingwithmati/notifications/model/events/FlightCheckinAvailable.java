package com.programmingwithmati.notifications.model.events;

import java.time.LocalDateTime;

public record FlightCheckinAvailable(
        LocalDateTime checkInTimeStarts,
        LocalDateTime checkInTimeEnds
) {
}
