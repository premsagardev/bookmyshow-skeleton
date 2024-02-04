package com.psdev.bookmyshowskelton.models;

public enum ShowSeatStatus {
    BOOKED,
    AVAILABLE,
    LOCKED, // Refers to the seat for which some user is on the payment.
}
