package com.app.util;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import com.app.model.User;

@Singleton
public class UserSession {

		private HashMap<String, User> session;
		
		@PostConstruct
		private void init() {
			session = new HashMap<String, User>();
		}
		
		public User getObject(User user)
		{
			String key = user.getUsername();
			if(session.containsKey(key))
			{
				System.out.println("Cache hit for " + key);
				return session.get(key);
			}
			else
			{
				System.out.println("Cache miss for " + key);
				return null;
			}
		}
		
		public void putObject(User user)
		{
			String key = user.getUsername();
			session.put(key, user);
			System.out.println("Cache put for " + key);
		}
}
