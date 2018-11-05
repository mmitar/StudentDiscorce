package com.app.business;

import java.util.ArrayList;
import java.util.List;

import com.app.data.UserDataService;
import com.app.model.User;

public class UserBusinessService implements UserBusinessInterface 
{
	UserDataService userDAO = new UserDataService();
	List<User> users = new ArrayList<User>();
	
	public UserBusinessService() 
	{
		users.add(new User("","","Richard", "Richards", "", "", "CST-341:0"));
		users.add(new User("","","Dennis", "Denniss", "", "", "CST-341:0||CST-341:1"));
		users.add(new User("","","Arthor", "Arthors", "", "", "CST-341:0||CST-341:1"));
		users.add(new User("","","James", "Jamess", "", "", "CST-341:0"));
		users.add(new User("","","Nathan", "Nathans", "", "", "CST-341:0"));
		users.add(new User("","","Emily", "Emilys", "", "", "CST-326:0"));
		users.add(new User("","","Liz", "Lizs", "", "", "CST-326:1"));
		users.add(new User("","","Tony", "Tonys", "", "", "CST-326:1"));
		users.add(new User("","","Mark", "Marks", "", "", "CST-326:0"));
		users.add(new User("","","Matthew", "Matthews", "", "", "CST-326:1"));
		users.add(new User("","","Devin", "Devins", "", "", "CST-326:0"));
		users.add(new User("","","Evan", "Evans", "", "", "CST-352:0"));
		users.add(new User("","","Kevin", "Kevins", "", "", "CST-352:2"));
		users.add(new User("","","Lenard", "Lenards", "", "", "CST-352:0"));
		users.add(new User("","","Michael", "Michaels", "", "", "CST-352:2||CST-341:1"));
		users.add(new User("","","Marge", "Marges", "", "", "CST-341:0||CST-352:1"));
		users.add(new User("","","Shela", "Shelas", "", "", "CST-341:0"));
		users.add(new User("","","Sam", "Sams", "", "", "CST-326:2"));
	}
	
	public User findBy(User user)
	{
		return this.userDAO.findBy(user);
	}
	
	public boolean create(User user)
	{
		return this.userDAO.create(user);
	}
	
	public void addConstructUsers()
	{
		for(User user : this.users)
		{
			this.userDAO.create(user);
		}
	}
	
	public void init() {
		System.out.println("init() from UserBusinessService");
	}
	
	public void destroy() {
		System.out.println("destroy() from UserBusinessService");
	}
	
	@Override
	public void test() {
		System.out.println("Hello from UserBusinessService.");
	}
}
