package by.bsu.fpmi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.bsu.fpmi.domain.Music;

@Repository
public class MusicDAO implements ICRUDRepository<Music>{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Music item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Music> readAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Music").list();
	}

	@Override
	public Music read(Integer id) {
		// TODO Auto-generated method stub
		return (Music)sessionFactory.getCurrentSession().load(Music.class, id);
	}

	@Override
	public void update(Music item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(item);
	}

	@Override
	public void remove(Music item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(item);
	}

}
