package org.example.events;

import java.util.ArrayList;
import java.util.List;

/**
 * Une liste d'évenement
 */
public class EventList {
    private List<Event> events;

    public EventList(){
        events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }
}
