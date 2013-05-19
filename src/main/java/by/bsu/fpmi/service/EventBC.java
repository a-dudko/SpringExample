package by.bsu.fpmi.service;

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
    public List<Event> listEvent() {
 
        return eventDAO.readAll();
    }
 
    @Transactional
    public void removeEvent(Event event) {
    	eventDAO.remove(event);
    }
}
