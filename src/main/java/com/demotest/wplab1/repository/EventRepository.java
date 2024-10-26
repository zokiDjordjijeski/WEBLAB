package com.demotest.wplab1.repository;

import com.demotest.wplab1.bootstrap.DataHolder;
import com.demotest.wplab1.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository {

    public List<Event> findAll() {
        return DataHolder.events;
    }

    public List<Event> searchEvents(String text) {
        return DataHolder.events
                .stream()
                .filter(event -> event.getName().contains(text) || event.getDescription().contains(text))
                .toList();
    }
}
