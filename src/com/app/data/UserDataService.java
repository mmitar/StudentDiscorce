package com.app.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.app.model.User;

@Named("userData")
public class UserDataService implements DataAccessInterface<User>{

	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public UserDataService() {}
	
	@Override
	public List<User> findAll() 
	{
		return null;
	}
	
	@Override 
	public List<User> findAll(User user)
	{
		return null;
	}
	
	@Override
	public User findBy(User user)
	{
		// READ query to identify the user by username and password
		String sql = "SELECT * FROM `studisc.users` WHERE `USERNAME` = '"+user.getUsername()+"' AND `PASSWORD` = '"+user.getPassword()+"'";
		try
		{
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			
			// Goes to the Last Row of the Results
			srs.beforeFirst();
			srs.last();
			
			// Checks the Size of the Results. If anything other than 1, return null
			if(srs.getRow() != 1)
			{
				return null;
			}
			
			// Last Row should still be the First, and return the user
			return User.getSqlRowSet(srs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(User user) 
	{
		// READ query to see if username is already taken
		String sql_1 = "SELECT * FROM `studisc.users` WHERE `USERNAME` = '"+user.getUsername()+"'";
		int rows_1 = jdbcTemplateObject.update(sql_1);
		
		// Return if it is
		if(rows_1 > 0)
		{
			return false;
		}
		
		// Create query that adds the user to the DB
		String sql = "INSERT INTO `studisc.users` (" + User.getSqlParams() + ") VALUES (" + User.getSqlValues(user) + ")";
		try
		{
			// Execute SQL Insert
			int rows = jdbcTemplateObject.update(sql);
			
			// Return Result of Insert
			return rows == 1 ? true : false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
