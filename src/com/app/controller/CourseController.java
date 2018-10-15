package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.business.CourseBusinessInterface;
import com.app.model.Course;
import com.app.model.User;

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
		
		System.out.println("init courseview");
//		System.out.println(course);
//		System.out.println(course.getId());
		
		ModelAndView mv = new ModelAndView("courseView");
		mv.addObject("course", course);
		
		return mv;
	}
	@RequestMapping(path="/addedCourse", method=RequestMethod.POST)
	public ModelAndView addCourse(@Valid @ModelAttribute("course")Course course, BindingResult result)
	{		
		//Validate the form
		if(result.hasErrors())
		{
			return new ModelAndView("addCourse", "course", course);
		}		
		service.test();
		
		return new ModelAndView("addedCourse", "course", course);
	}
	
	@RequestMapping(path="/addCourse", method=RequestMethod.GET)
	public ModelAndView displayForm1()
	{
		return new ModelAndView("addCourse", "course", new Course());
	}
	
}
