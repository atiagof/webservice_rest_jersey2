package br.com.acme.webservice.rest.dao;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GenericDAO<T> {
	
	public List<T> listAll();
	public List<T> listByPeriod();
	public T details(Long id);
	public void persist(T object);
	public void remove(T object);
	public void update(T object);
	
}
