package by.bsu.fpmi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDAO<E> implements ICRUDRepository<E> {

	private Class<E> type;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public GenericDAO(Class<E> type) {
		this.type = type;
	}
	
	@Override
	public void add(E item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> readAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from " + type.getName()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(Integer id) {
		// TODO Auto-generated method stub
		return (E)sessionFactory.getCurrentSession().get(type, id);
	}

	@Override
	public void update(E item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(item);
	}

	@Override
	public void remove(E item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(item);
	}

}
