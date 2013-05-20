package by.bsu.fpmi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.bsu.fpmi.domain.Profile;

@Repository
public class ProfileDAO implements ICRUDRepository<Profile> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Profile item) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(item);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profile> readAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Profile").list();
	}

	@Override
	public Profile read(Integer id) {
		// TODO Auto-generated method stub
		return (Profile)sessionFactory.getCurrentSession().load(Profile.class, id);
	}

	@Override
	public void update(Profile item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(item);
	}

	@Override
	public void remove(Profile item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(item);
	}

}
