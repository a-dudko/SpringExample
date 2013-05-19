package by.bsu.fpmi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.bsu.fpmi.domain.Address;

@Repository
public class AddressDAO implements ICRUDRepository<Address>{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Address item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> readAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Address").list();
	}

	@Override
	public Address read(Integer id) {
		// TODO Auto-generated method stub
		return (Address)sessionFactory.getCurrentSession().load(Address.class, id);
	}

	@Override
	public void update(Address item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(item);
	}

	@Override
	public void remove(Address item) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(item);
	}

}
