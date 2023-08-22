package com.scaler.BookMyShow.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum BookingStatus {
    CONFIRMED, CANCELLED, PENDING;
}
