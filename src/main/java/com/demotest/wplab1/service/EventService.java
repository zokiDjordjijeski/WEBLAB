package com.demotest.wplab1.service;

import com.demotest.wplab1.model.Event;

import java.util.List;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvent(String text);
}
