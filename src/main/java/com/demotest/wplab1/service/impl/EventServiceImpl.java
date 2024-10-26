package com.demotest.wplab1.service.impl;

import com.demotest.wplab1.model.Event;
import com.demotest.wplab1.repository.EventRepository;
import com.demotest.wplab1.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvent(String text) {
        return this.eventRepository.searchEvents(text);
    }
}
