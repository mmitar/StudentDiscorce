package com.app.business;

import java.util.List;

import com.app.model.Class;

public class ClassBusinessService implements ClassBusinessInterface
{
	UserBusinessInterface service;

	List<Class> classes;
	
	public ClassBusinessService() 
	{
		classes.add(new Class("CST-341",
				"Open Source Computing",
				"Develop a Spring Application",
				"Software Development",
				"16-104",
				"1:00-2:45pm||Tu,We,Th",
				"3:00-5:00pm||Tu,We,Th",
				service.getInstructors(),service.getTutors(),service.getStudents(),
				"https://www.csuci.edu/img/launch-virtual-tour-16x9.jpg"));
		classes.add(new Class("CST-326",
				"Written and Verbal Communication",
				"Integrating Team Mangement Skills with Project Development",
				"Liberal Arts",
				"4-224",
				"3:00-4:45pm||Tu,We,Th",
				"5:00-7:00pm||Tu,We,Th",
				service.getInstructors(),service.getTutors(),service.getStudents(),
				"https://www.rider.edu/sites/default/files/styles/hero_image_-_no_play_icon/public/featuredimages/111114_campus_112_0.jpg?itok=7hDr78hX"));
		classes.add(new Class("BUS-352",
				"Business Statistics",
				"Calculate, Assume, and Gentrify Economic Anomalies",
				"Software Development",
				"20-401",
				"8:00-9:00pm||Tu,We,Th",
				"5:00-6:00pm||Tu,We,Th",
				service.getInstructors(),service.getTutors(),service.getStudents(),
				"https://uwm.edu/wp-content/uploads/2017/07/downer-cluster-900X500.jpg"));
	}
	
	public void init() {
		System.out.println("init() from ClassBusinessService");
	}
	
	public void destroy() {
		System.out.println("destroy() from ClassBusinessService");
	}
	
	@Override
	public void test() {
		System.out.println("Hello from ClassBusinessService.");
	}
}
