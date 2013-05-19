package by.bsu.fpmi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.bsu.fpmi.domain.Comment;

@Repository
public class CommentDAO implements ICRUDRepository<Comment>{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Comment item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> readAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Comment").list();
	}

	@Override
	public Comment read(Integer id) {
		// TODO Auto-generated method stub
		return (Comment) sessionFactory.getCurrentSession().load(Comment.class, id);
	}

	@Override
	public void update(Comment item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(item);
	}

	@Override
	public void remove(Comment item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(item);
	}

}
