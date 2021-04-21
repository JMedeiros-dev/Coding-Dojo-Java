package dev.johnmedeiros.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.johnmedeiros.events.models.Event;
import dev.johnmedeiros.events.repositories.EventRepository;

@Service
public class EventService {
	
private final EventRepository eventRepository;
    
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
	
    // returns all the events
    public List<Event> allEvents() {
        return eventRepository.findAll();
    }
    
    // creates a event
    public Event createEvent(Event e) {
        return eventRepository.save(e);
    }
    
    // retrieves a event
    public Event findEvent(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if(optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
    }
    
    // deletes a event
    public void deleteEvent(Long id) {
    	eventRepository.deleteById(id);
    }

}
