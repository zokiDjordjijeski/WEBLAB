package com.demotest.wplab1.service.impl;

import com.demotest.wplab1.model.Event;
import com.demotest.wplab1.repository.jpa.EventRepository;
import com.demotest.wplab1.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Optional<Event> findById(Long id) {
        return this.eventRepository.findById(id);
    }

    @Override
    public Optional<List<Event>> listAll() {
        return Optional.of(this.eventRepository.findAll());
    }

    @Override
    public Optional<List<Event>> searchEvent(String text) {
        return Optional.of(this.eventRepository.findAllByName(text));
    }

    @Override
    public Optional<Event> addOrUpdateEvent(Event event) {
        return Optional.of(this.eventRepository.save(event));
    }

    @Override
    public void deleteEvent(Long id) {
        this.eventRepository.deleteEventById(id);
    }
}
