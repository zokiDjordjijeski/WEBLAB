package com.demotest.wplab1.web.controller;

import com.demotest.wplab1.model.Category;
import com.demotest.wplab1.model.Event;
import com.demotest.wplab1.model.Location;
import com.demotest.wplab1.service.impl.CategoryServiceImpl;
import com.demotest.wplab1.service.impl.EventServiceImpl;
import com.demotest.wplab1.service.impl.LocationServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = {"/events"})
public class EventController {

    private final LocationServiceImpl locationService;
    private final EventServiceImpl eventService;
    private final CategoryServiceImpl categoryService;

    public EventController(LocationServiceImpl locationService, EventServiceImpl eventService, CategoryServiceImpl categoryService) {
        this.locationService = locationService;
        this.eventService = eventService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        List<Event> eventList = this.eventService.listAll().orElseThrow(() -> new RuntimeException("There are no locations"));
        List<Location> locationList = this.locationService.findAll().orElseThrow(() -> new RuntimeException("There are no locations"));
        model.addAttribute("events", eventList);
        model.addAttribute("locations_for_filter", locationList);
        return "listEvents";
    }

    @GetMapping(path = "/locations")
    public String getLocationsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        List<Location> locationList = this.locationService.findAll().orElseThrow(() -> new RuntimeException("There are no locations"));
        model.addAttribute("locations", locationList);
        model.addAttribute("locations_for_filter", locationList);
        return "listEvents";
    }

    // TODO THIS IS NOT NEEDED
//    @GetMapping(path = "/add-form")
//    public String getAddEventPage(Model model) {
//        // No need for this
//        List<Location> locationList = this.locationService.findAll().orElseThrow(() -> new RuntimeException("There are no locations"));
//        model.addAttribute("event", new Event());
//        model.addAttribute("locations", locationList);
//        return "addEvent";
//    }

    @GetMapping(path = "/add")
    public String addEvent(Model model) {
        List<Location> locationList = this.locationService.findAll().orElseThrow(() -> new RuntimeException("There are no locations"));
        List<Category> categoryList = this.categoryService.findAllCategories();
        model.addAttribute("event", new Event());
        model.addAttribute("locations", locationList);
        model.addAttribute("categories", categoryList);
        return "add-event";
    }

    @PostMapping(path = "/add")
    public String saveEvent(@RequestParam String name,
                            @RequestParam String description,
                            @RequestParam Double popularityScore,
                            @RequestParam Long locationId,
                            @RequestParam Long categoryId) {
        List<Location> locationList = this.locationService.findAll().orElseThrow(() -> new RuntimeException("There are no locations"));
        Location location = locationList.stream().filter(x -> x.getId().equals(locationId)).findFirst().orElseThrow(() -> new RuntimeException("There is no location with id: " + locationId));
        Category category = this.categoryService.findAllCategories().stream().filter(x -> x.getId().equals(categoryId)).findFirst().orElse(null);
        Event event = new Event(name, description, popularityScore, location, category);
        this.eventService.addOrUpdateEvent(event);
        return "redirect:/events";
    }

    @GetMapping(path = "/edit-event/{eventId}")
    public String getEditEventForm(@PathVariable Long eventId, Model model) {
        Event event = this.eventService.findById(eventId).orElseThrow(() -> new RuntimeException("There is no event"));
        List<Category> categoryList = this.categoryService.findAllCategories();
        if (event == null) {
            return "redirect:/events?error=EventNotFound";
        }
        List<Location> locationList = this.locationService.findAll().orElseThrow(() -> new RuntimeException("There are no locations"));
        model.addAttribute("event", event);
        model.addAttribute("locations", locationList);
        model.addAttribute("categories", categoryList);
        return "add-event";
    }


    @PostMapping(path = "/edit/{eventId}")
    public String editEvent(@PathVariable Long eventId, HttpServletRequest request) {
        Event event = this.eventService.listAll().orElseThrow(RuntimeException::new).stream().filter(x -> x.getId().equals(eventId)).findFirst().orElse(null);
        if (event == null) {
            return "redirect:/events?error=EventNotFound";
        }
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Double popularityScore = Double.parseDouble(request.getParameter("popularityScore"));
        Long locationId = Long.parseLong(request.getParameter("locationId"));
        Long categoryId = Long.parseLong(request.getParameter("categoryId"));
        Location location = this.locationService.findAll().orElseThrow(RuntimeException::new).stream().filter(x -> x.getId().equals(locationId)).findFirst().orElse(null);
        Category category = this.categoryService.findAllCategories().stream().filter(x -> x.getId().equals(categoryId)).findFirst().orElse(null);
        this.eventService.addOrUpdateEvent(new Event(name, description, popularityScore, location, category));

        return "redirect:/test";
    }

    @Transactional
    @PostMapping(path = "/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        Event event = this.eventService.listAll().orElseThrow(() -> new RuntimeException("There is no event with id: " + id)).stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        if (event != null) {
            System.out.println("Event exists");
        }
        this.eventService.deleteEvent(id);
        return "redirect:/";
    }

    @PostMapping(path = "/search-location")
    public String searchLocation(@RequestParam("location") Long id, Model model) {
        List<Event> locationList = this.eventService.listAll().orElseThrow(() -> new RuntimeException("There are no locations"));
        model.addAttribute("locations_if_filter", locationList.stream().filter(x -> x.getId() == id).toList());
        model.addAttribute("locations_for_filter", locationList);
        return "listEvents";
    }
}
