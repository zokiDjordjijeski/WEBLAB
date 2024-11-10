package com.demotest.wplab1.service;

import com.demotest.wplab1.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Optional<List<Event>> listAll();
    Optional<List<Event>> searchEvent(String text);
    Optional<Event> addOrUpdateEvent(Event event);
    void deleteEvent(Long id);
}
