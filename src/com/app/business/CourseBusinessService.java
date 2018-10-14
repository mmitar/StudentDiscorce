package com.app.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.Course;

public class CourseBusinessService implements CourseBusinessInterface
{
//	UserBusinessService service;
	
	List<Course> courses = new ArrayList<Course>();
	
	public CourseBusinessService() 
	{
		courses.add(new Course("CST-341",
				"Open Source Computing",
				"Develop a Spring Application",
				"Software Development",
				"16-104",
				"1:00-2:45pm||Tu,We,Th",
				"3:00-5:00pm||Tu,We,Th",
//				service.getInstructors(),service.getTutors(),service.getStudents(),
				null,null,null,
				"https://www.csuci.edu/img/launch-virtual-tour-16x9.jpg"));
		courses.add(new Course("CST-326",
				"Written and Verbal Communication",
				"Integrating Team Mangement Skills with Project Development",
				"Liberal Arts",
				"4-224",
				"3:00-4:45pm||Tu,We,Th",
				"5:00-7:00pm||Tu,We,Th",
//				service.getInstructors(),service.getTutors(),service.getStudents(),
				null,null,null,
				"https://www.rider.edu/sites/default/files/styles/hero_image_-_no_play_icon/public/featuredimages/111114_campus_112_0.jpg?itok=7hDr78hX"));
		courses.add(new Course("BUS-352",
				"Business Statistics",
				"Calculate, Assume, and Gentrify Economic Anomalies",
				"Software Development",
				"20-401",
				"8:00-9:00pm||Tu,We,Th",
				"5:00-6:00pm||Tu,We,Th",
//				service.getInstructors(),service.getTutors(),service.getStudents(),
				null,null,null,
				"https://uwm.edu/wp-content/uploads/2017/07/downer-cluster-900X500.jpg"));
	}
	
	public List<Course> getCourses() 
	{
		return courses;
	}
	
	public void init() {
		System.out.println("init() from CourseBusinessService");
	}
	
	public void destroy() {
		System.out.println("destroy() from CourseBusinessService");
	}
	
	@Override
	public void test() {
		System.out.println("Hello from CourseBusinessService.");
	}
}
