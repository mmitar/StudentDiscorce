package com.app.business;

import java.util.List;

import com.app.model.Course;

public interface CourseBusinessInterface 
{
	public List<Course> getCourses();
	public void init();
	public void destroy();
	public void test();
}
