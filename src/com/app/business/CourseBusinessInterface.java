package com.app.business;

import java.util.List;

import com.app.model.Course;

public interface CourseBusinessInterface 
{
	public Course findBy(Course course);
	public List<Course> findAll(Course course);
	public List<Course> findAll();
	public boolean createCourse(Course course);
	
	public void init();
	public void destroy();
	public void test();
}
