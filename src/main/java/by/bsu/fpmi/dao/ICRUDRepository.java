package by.bsu.fpmi.dao;

import java.util.List;

public interface ICRUDRepository<E> {
	
	public void add(E item);
	public List<E> readAll();
	public E read(Integer id);
	public void update(E item);
	public void remove(E item); 
}
