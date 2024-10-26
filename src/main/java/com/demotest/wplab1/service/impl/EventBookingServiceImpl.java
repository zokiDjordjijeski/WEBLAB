package com.demotest.wplab1.service.impl;

import com.demotest.wplab1.model.EventBooking;
import com.demotest.wplab1.model.exception.InvalidArgsException;
import com.demotest.wplab1.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, long numberOfTickets) {
        if (eventName == null || attendeeName == null || attendeeAddress == null || numberOfTickets <= 0)
            throw new InvalidArgsException();
        return new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);
    }
}
