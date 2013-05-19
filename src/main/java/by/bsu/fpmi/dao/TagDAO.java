package by.bsu.fpmi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.bsu.fpmi.domain.Tag;

@Repository
public class TagDAO implements ICRUDRepository<Tag> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Tag item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> readAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Tag").list();
	}

	@Override
	public Tag read(Integer id) {
		// TODO Auto-generated method stub
		return (Tag)sessionFactory.getCurrentSession().load(Tag.class, id);
	}

	@Override
	public void update(Tag item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(item);
	}

	@Override
	public void remove(Tag item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(item);
	}

}
