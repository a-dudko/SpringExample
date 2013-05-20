package by.bsu.fpmi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.bsu.fpmi.dao.EventDAO;
import by.bsu.fpmi.domain.Event;

@Service
public class EventBC {

	@Autowired
    private EventDAO eventDAO;
     
    @Transactional
    public void addEvent(Event event) {
        eventDAO.add(event);
    }
 
    @Transactional
    public List<Event> getEvents() {
 
        return eventDAO.readAll();
    }
 
    @Transactional
    public int getCounts() {
    	List<Event> events = getEvents();
    	if (events != null) {
    		return events.size();
    	}
    	return 0;
    }
    
    @Transactional
    public Event getEvent(Integer id) {
 
        return eventDAO.read(id);
    }   
    
    @Transactional
    public void updateEvent(Event event) {
        eventDAO.update(event);
    }
    
    @Transactional
    public void removeEvent(Event event) {
    	eventDAO.remove(event);
    }
    
    @Transactional
    public List<Event> getRange(int firstElement, int secondElement) {
    	List<Event> events = this.getEvents();
    	List<Event> eventsRange = new ArrayList<Event>();
    	secondElement = Math.min(secondElement + 1, events.size());
    	firstElement = Math.min(firstElement,events.size());
    	for (int i = firstElement; i < secondElement; i++) {
    		eventsRange.add(events.get(i));
    	}
    	return eventsRange;
    }
}
