package by.bsu.fpmi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.bsu.fpmi.domain.Photo;

@Repository
public class PhotoDAO implements ICRUDRepository<Photo> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Photo item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> readAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Photo").list();
	}

	@Override
	public Photo read(Integer id) {
		// TODO Auto-generated method stub
		return (Photo)sessionFactory.getCurrentSession().load(Photo.class, id);
	}

	@Override
	public void update(Photo item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(item);
	}

	@Override
	public void remove(Photo item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(item);
	}

}
