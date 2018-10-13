package com.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.business.UserBusinessInterface;
import com.app.model.User;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	private UserBusinessInterface service;
	
	public void setUserService(UserBusinessInterface service)
	{
		this.service = service;
	}
	
	/**
	 * displayForm
	 * Navigates the user via URI to the login view with an empty User model
	 * 
	 * @return ModelAndView loginUser
	 */
	@RequestMapping(path="/user", method=RequestMethod.GET)
	public ModelAndView displayForm()
	{
		return new ModelAndView("loginUser", "user", new User("", "", "", "", "", "", ""));
	}
	
	/**
	 * loginUser
	 * Validates the form post user model for validation errors. if error: nav back to loginUser
	 * if successful, nav forward to dashboard.
	 * 
	 * @param User user
	 * @param BindingResult result
	 * @return ModelAndView loginUser, user
	 * @return ModelAndView dashboard, user
	 */
	@RequestMapping(path="/validateUser", method=RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("user")User user, BindingResult result)
	{
		//Validate the form
		if(result.hasErrors())
		{
			return new ModelAndView("loginUser", "user", user);
		}
		
		service.test();
		
		return new ModelAndView("dashboard", "user", user);
	}
	
	/**
	 * viewDashboard
	 * Navs user the dashboard via URI.
	 * 
	 * @return View dashboard
	 */
	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String viewDashboard() 
	{
		return "dashboard";
	}
	
	
}
