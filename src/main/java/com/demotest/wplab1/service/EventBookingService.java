package com.demotest.wplab1.service;

import com.demotest.wplab1.model.EventBooking;

public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, long numberOfTickets);
}