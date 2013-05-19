package by.bsu.fpmi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.bsu.fpmi.domain.Event;

@Repository
public class EventDAO implements ICRUDRepository<Event> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Event item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> readAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Event").list();
	}

	@Override
	public Event read(Integer id) {
		// TODO Auto-generated method stub
		Event event = (Event)sessionFactory.getCurrentSession().load(Event.class, id);
		return event;
	}

	@Override
	public void update(Event item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(item);
	}

	@Override
	public void remove(Event item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(item);
	}

}
