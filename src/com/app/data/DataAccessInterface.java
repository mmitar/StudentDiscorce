package com.app.data;

import java.util.List;

public interface DataAccessInterface <T> 
{
	public List<T> findAll();
	public List<T> findAll(T t);
	public T findBy(T t);
	public T findById(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
