package org.example.notification;

public record NotificationRequest(
        Integer toEmployeeId,
        String toEmployeeEmail,
        String message
) {
}