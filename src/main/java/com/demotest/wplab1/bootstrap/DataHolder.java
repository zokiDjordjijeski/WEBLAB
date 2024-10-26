package com.demotest.wplab1.bootstrap;

import com.demotest.wplab1.model.Event;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = new ArrayList<>();

    @PostConstruct
    public void init() {
        events.add(new Event("EventCenter1","Karaoke",10.0));
        events.add(new Event("EventCenter2","Sleeping",9.1));
        events.add(new Event("EventCenter","Dance off",10.0));
        events.add(new Event("EventCenter4","Swimming",10.0));
        events.add(new Event("EventCenter","Skiing",7.2));
        events.add(new Event("EventCenter6","Hiking",1.1));
        events.add(new Event("EventCenter","Sleeping",3.9));
        events.add(new Event("EventCenter8","Wrestling",5.0));
        events.add(new Event("EventCenter9","Boxing",8.3));
        events.add(new Event("EventCenter10","Sleeping",7.3));
    }
}
