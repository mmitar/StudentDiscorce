package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.business.ClassBusinessInterface;

@Controller
@RequestMapping("/class")
public class ClassController 
{
	private ClassBusinessInterface service;
	
	public void setClassService(ClassBusinessInterface service)
	{
		this.service = service;
	}
	
	/**
	 * displayForm
	 * Navs the user to the classList page via URI. Currently no model is currently implemented
	 * but one eventually be made further in the project.
	 *
	 * @return ModelAndView classList
	 */
	@RequestMapping(path="/new", method=RequestMethod.GET)
	public ModelAndView displayForm()
	{
		service.test();
		
		return new ModelAndView("classList");
	}
}
