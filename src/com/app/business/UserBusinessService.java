package com.app.business;

import java.util.ArrayList;
import java.util.List;
import com.app.model.User;

public class UserBusinessService implements UserBusinessInterface 
{
	List<User> users;
	
	public UserBusinessService() 
	{
		users.add(new User("","","Richard", "Richards", "", "", "0"));
		users.add(new User("","","Dennis", "Denniss", "", "", "0||1"));
		users.add(new User("","","Arthor", "Arthors", "", "", "0||1"));
		users.add(new User("","","James", "Jamess", "", "", "0"));
		users.add(new User("","","Nathan", "Nathans", "", "", "0"));
		users.add(new User("","","Emily", "Emilys", "", "", "0"));
		users.add(new User("","","Liz", "Lizs", "", "", "1"));
		users.add(new User("","","Tony", "Tonys", "", "", "1"));
		users.add(new User("","","Mark", "Marks", "", "", "0"));
		users.add(new User("","","Matthew", "Matthews", "", "", "1"));
		users.add(new User("","","Devin", "Devins", "", "", "0"));
		users.add(new User("","","Evan", "Evans", "", "", "0"));
		users.add(new User("","","Kevin", "Kevins", "", "", "2"));
		users.add(new User("","","Lenard", "Lenards", "", "", "0"));
		users.add(new User("","","Michael", "Michaels", "", "", "2||1"));
		users.add(new User("","","Marge", "Marges", "", "", "0||1"));
		users.add(new User("","","Shela", "Shelas", "", "", "0"));
		users.add(new User("","","Sam", "Sams", "", "", "2"));
	}
	
	public List<User> getTutors () 
	{
		List<User> tutors = new ArrayList<User>();
		
		for (User user : this.users)
		{
			if(user.getPermission().contains("1"))
			{
				tutors.add(user);
			}
		}
		
		return tutors;
	}
	
	public List<User> getInstructors ()
	{
		List<User> instructors = new ArrayList<User>();
		
		for (User user : this.users)
		{
			if(user.getPermission().contains("2"))
			{
				instructors.add(user);
			}
		}
		
		return instructors;
	}
	
	public List<User> getStudents ()
	{
		List<User> students = new ArrayList<User>();
		
		for (User user : this.users) 
		{
			if(user.getPermission().contains("0")) 
			{
				students.add(user);
			}
		}
		
		return students;
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
