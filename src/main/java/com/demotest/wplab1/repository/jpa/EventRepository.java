package com.demotest.wplab1.repository.jpa;

import com.demotest.wplab1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByLocation_Id(Long locationId);
    List<Event> findAllByName(String name);
    void deleteEventById(Long id);
}
