package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.business.CourseBusinessInterface;
import com.app.model.Course;

@Controller
@RequestMapping("/course")
public class CourseController 
{
	private CourseBusinessInterface service;
	
	@Autowired
	public void setCourseService(CourseBusinessInterface service)
	{
		this.service = service;
	}
	
	/**
	 * displayForm
	 * Navs the user to the courseList page via URI. Currently no model is currently implemented
	 * but one eventually be made further in the project.
	 *
	 * @return ModelAndView courseList
	 */
	@RequestMapping(path="/new", method=RequestMethod.GET)
	public ModelAndView displayForm()
	{
		service.test();
		
		return new ModelAndView("courseList");
	}
	
	@RequestMapping(path="/courseView", method=RequestMethod.POST)
	public ModelAndView displayCourse(@ModelAttribute("course")Course course) {
		
		return new ModelAndView("courseView", "course", course);
	}
}
