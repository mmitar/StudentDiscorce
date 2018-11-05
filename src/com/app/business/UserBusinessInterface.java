package com.app.business;

import java.util.List;

import com.app.model.User;

public interface UserBusinessInterface 
{
	public User findBy(User user);
	public boolean create(User user);

	public void init();
	public void destroy();
	public void test();
}
