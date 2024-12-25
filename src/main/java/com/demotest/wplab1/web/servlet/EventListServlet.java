package com.demotest.wplab1.web.servlet;

import com.demotest.wplab1.model.Event;
import com.demotest.wplab1.service.impl.EventServiceImpl;
import com.demotest.wplab1.service.impl.LocationServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EventListServlet", urlPatterns = {"", "/test", "/test/searchByText", "/test/searchByRating"})
public class EventListServlet extends HttpServlet {
    private final EventServiceImpl eventService;
    private final LocationServiceImpl locationService;
    protected final SpringTemplateEngine templateEngine;

    public EventListServlet(EventServiceImpl eventService, LocationServiceImpl locationService, SpringTemplateEngine templateEngine) {
        this.eventService = eventService;
        this.locationService = locationService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext webContext = new WebContext(webExchange);

        webContext.setVariable("events", this.eventService.listAll().orElseThrow(RuntimeException::new));
        webContext.setVariable("locations_for_filter", this.locationService.findAll().orElseThrow(RuntimeException::new));
        this.templateEngine.process("listEvents.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext webContext = new WebContext(webExchange);
        String path = req.getServletPath();
        List<Event> events = null;

        if (path.equals("/test/searchByText")) {
            String text = req.getParameter("text");
            events = this.eventService.searchEvent(text).orElseThrow(RuntimeException::new);
            webContext.setVariable("textSearchResults", events);
        } else if (path.equals("/test/searchByRating")) {
            double rating = Double.parseDouble(req.getParameter("rating"));
            events = this.eventService.listAll().orElseThrow(RuntimeException::new).stream()
                    .filter(event -> event.getPopularityScore() >= rating)
                    .toList();
            webContext.setVariable("ratingSearchResults", events);
        } else {
            events = this.eventService.listAll().orElseThrow(RuntimeException::new);
            webContext.setVariable("events", events);
        }
        webContext.setVariable("locations_for_filter", this.locationService.findAll().orElseThrow(RuntimeException::new));
        this.templateEngine.process("listEvents.html", webContext, resp.getWriter());
    }
}
