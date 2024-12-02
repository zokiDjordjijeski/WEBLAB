package com.demotest.wplab1.bootstrap;

import com.demotest.wplab1.model.Event;
import com.demotest.wplab1.model.Location;
import com.demotest.wplab1.repository.jpa.EventRepository;
import com.demotest.wplab1.repository.jpa.LocationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = new ArrayList<>();
    public static List<Location> locations = new ArrayList<>();

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public DataHolder(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @PostConstruct
    public void init() {
//        Location location1 = this.locationRepository.save(new Location("Location1", "Address1", "100", "This is Location1 description"));
//        Location location2 = this.locationRepository.save(new Location("Location2", "Address2", "200", "This is Location2 description"));
//        Location location3 = this.locationRepository.save(new Location("Location3", "Address3", "300", "This is Location3 description"));
//        Location location4 = this.locationRepository.save(new Location("Location4", "Address4", "400", "This is Location4 description"));
//        Location location5 = this.locationRepository.save(new Location("Location5", "Address5", "500", "This is Location5 description"));
//
//        // Save Events, now that locations exist
//        this.eventRepository.save(new Event("EventCenter1", "Karaoke", 10.0, location1));
//        this.eventRepository.save(new Event("EventCenter2", "Sleeping", 9.1, location2));
//        this.eventRepository.save(new Event("EventCenter", "Dance off", 10.0, location3));
//        this.eventRepository.save(new Event("EventCenter4", "Swimming", 10.0, location4));
//        this.eventRepository.save(new Event("EventCenter", "Skiing", 7.2, location5));
//        this.eventRepository.save(new Event("EventCenter6", "Hiking", 1.1, location1));
//        this.eventRepository.save(new Event("EventCenter", "Sleeping", 3.9, location2));
//        this.eventRepository.save(new Event("EventCenter8", "Wrestling", 5.0, location3));
//        this.eventRepository.save(new Event("EventCenter9", "Boxing", 8.3, location4));
//        this.eventRepository.save(new Event("EventCenter10", "Sleeping", 7.3, location5));
    }
}
