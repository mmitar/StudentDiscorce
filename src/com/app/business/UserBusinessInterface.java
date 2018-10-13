package com.app.business;

import java.util.List;

import com.app.model.User;

public interface UserBusinessInterface 
{
	public List<User> getStudents();
	public List<User> getTutors();
	public List<User> getInstructors();
	public void init();
	public void destroy();
	public void test();
}
