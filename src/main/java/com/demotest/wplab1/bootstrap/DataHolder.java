package com.demotest.wplab1.bootstrap;

import com.demotest.wplab1.model.Event;
import com.demotest.wplab1.model.Location;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = new ArrayList<>();
    public static List<Location> locations = new ArrayList<>();

    @PostConstruct
    public void init() {
        locations.add(new Location("Location1", "Address1", "100", "This is Location1 description"));
        locations.add(new Location("Location2", "Address2", "200", "This is Location2 description"));
        locations.add(new Location("Location3", "Address3", "300", "This is Location3 description"));
        locations.add(new Location("Location4", "Address4", "400", "This is Location4 description"));
        locations.add(new Location("Location5", "Address5", "500", "This is Location5 description"));

        events.add(new Event("EventCenter1", "Karaoke", 10.0, locations.get(0)));
        events.add(new Event("EventCenter2", "Sleeping", 9.1, locations.get(1)));
        events.add(new Event("EventCenter", "Dance off", 10.0, locations.get(2)));
        events.add(new Event("EventCenter4", "Swimming", 10.0, locations.get(3)));
        events.add(new Event("EventCenter", "Skiing", 7.2, locations.get(4)));
        events.add(new Event("EventCenter6", "Hiking", 1.1, locations.get(0)));
        events.add(new Event("EventCenter", "Sleeping", 3.9, locations.get(1)));
        events.add(new Event("EventCenter8", "Wrestling", 5.0, locations.get(2)));
        events.add(new Event("EventCenter9", "Boxing", 8.3, locations.get(3)));
        events.add(new Event("EventCenter10", "Sleeping", 7.3, locations.get(4)));
    }
}
