package com.demotest.wplab1.repository.in_memory;

import com.demotest.wplab1.bootstrap.DataHolder;
import com.demotest.wplab1.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class EventRepositoryInMemory {

    public List<Event> findAll() {
        return DataHolder.events;
    }

    public List<Event> searchEvents(String text) {
        return DataHolder.events
                .stream()
                .filter(event -> event.getName().contains(text) || event.getDescription().contains(text))
                .toList();
    }

    public Event addOrUpdateEvent(Event event) {
        DataHolder.events.removeIf(x -> x.getName().equals(event.getName()) || x.getDescription().equals(event.getDescription()));
        DataHolder.events.add(event);
        return event;
    }

    public void deleteEvent(Long id) {
        DataHolder.events.removeIf(x -> Objects.equals(x.getId(), id));
    }
}
