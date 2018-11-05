package com.app.data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.app.model.Course;
import com.app.model.User;

@Named("courseData")
public class CourseDataService implements DataAccessInterface<Course>{

	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public CourseDataService() {}
	
	@Override
	public List<Course> findAll()
	{
		List<Course> courses = new ArrayList<Course>();
		List<User> instructors = new ArrayList<User>();
		List<User> tutors = new ArrayList<User>();
		List<User> students = new ArrayList<User>();
		
		// READ query that searches approximate matches for courses searched
		String sql_1 = "SELECT * FROM `studisc.courses` LIMIT 100";
		try
		{
			SqlRowSet srs_1 = jdbcTemplateObject.queryForRowSet(sql_1);
			
			// Iterate through all the results of the courses found
			while(srs_1.next())
			{
				Course newCourse = Course.getSqlRowSet(srs_1);
				
				// READ query to get the users affiliated with the course that was found.
				String sql_2 = "SELECT * FROM `studisc.users` WHERE `PERMISSION` = '%"+newCourse.getCourseID()+"%'";
				SqlRowSet srs_2 = jdbcTemplateObject.queryForRowSet(sql_2);
				
				// Iterate through all results of users affiliated with the course
				while(srs_2.next())
				{
					User user = User.getSqlRowSet(srs_2);
					
					// Split Key->Value pairs from each other
					String[] perms = user.getPermission().split("||");
					
					// Iterate through all permissions the user may have
					for(String perm: perms) {
						
						// Split the Permission Key from Value. Key is CourseID -> Value is Authority level.
						String[] permHash = perm.split(":");
						
						// If the permission 'Key' is related to the course, add them based on its level. User may have multiple levels.
						if(permHash[0].equals(newCourse.getCourseID()))
						{
							if(permHash[1].equals("2"))
							{
								instructors.add(user);
							}
							if(permHash[1].equals("1"))
							{
								tutors.add(user);
							}
							if(permHash[1].equals("0"))
							{
								students.add(user);
							}
						}
						
					} // For Each Loop
					
				} // While next user
				
				// Add the Lists of User Permission Types to the course
				newCourse.setInstructors(instructors);
				newCourse.setTutors(tutors);
				newCourse.setStudents(students);
				
				// Add the compiled course to the List of Courses and continue iterating
				courses.add(newCourse);
				
			} // While next course
			
			return courses;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<Course> findAll(Course course)
	{
		List<Course> courses = new ArrayList<Course>();
		List<User> instructors = new ArrayList<User>();
		List<User> tutors = new ArrayList<User>();
		List<User> students = new ArrayList<User>();
		
		// READ query that searches approximate matches for courses searched
		String sql_1 = "SELECT * FROM `studisc.courses` WHERE `COURSE_ID` LIKE '"+course.getCourseID()+"'"
														+ " OR `TITLE` LIKE '"+course.getTitle()+"'";
		try
		{
			SqlRowSet srs_1 = jdbcTemplateObject.queryForRowSet(sql_1);
			
			// Iterate through all the results of the courses found
			while(srs_1.next())
			{
				Course newCourse = Course.getSqlRowSet(srs_1);
				
				// READ query to get the users affiliated with the course that was found.
				String sql_2 = "SELECT * FROM `studisc.users` WHERE `PERMISSION` = '%"+course.getCourseID()+"%'";
				SqlRowSet srs_2 = jdbcTemplateObject.queryForRowSet(sql_2);
				
				// Iterate through all results of users affiliated with the course
				while(srs_2.next())
				{
					User user = User.getSqlRowSet(srs_2);
					
					// Split Key->Value pairs from each other
					String[] perms = user.getPermission().split("||");
					
					// Iterate through all permissions the user may have
					for(String perm: perms) {
						
						// Split the Permission Key from Value. Key is CourseID -> Value is Authority level.
						String[] permHash = perm.split(":");
						
						// If the permission 'Key' is related to the course, add them based on its level. User may have multiple levels.
						if(permHash[0].equals(course.getCourseID()))
						{
							if(permHash[1].equals("2"))
							{
								instructors.add(user);
							}
							if(permHash[1].equals("1"))
							{
								tutors.add(user);
							}
							if(permHash[1].equals("0"))
							{
								students.add(user);
							}
						}
						
					} // For Each Loop
					
				} // While next user
				
				// Add the Lists of User Permission Types to the course
				newCourse.setInstructors(instructors);
				newCourse.setTutors(tutors);
				newCourse.setStudents(students);
				
				// Add the compiled course to the List of Courses and continue iterating
				courses.add(newCourse);
				
			} // While next course
			
			return courses;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Course findBy(Course course)
	{
		List<User> instructors = new ArrayList<User>();
		List<User> tutors = new ArrayList<User>();
		List<User> students = new ArrayList<User>();
		
		try
		{
			String sql = "SELECT * FROM `studisc.courses` WHERE `COURSE_ID` = '" + course.getCourseID() + "'";
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			
			course = Course.getSqlRowSet(srs);
			
			// READ query to get the users affiliated with the course that was found.
			String sql_2 = "SELECT * FROM `studisc.users` WHERE `PERMISSION` = '%"+course.getCourseID()+"%'";
			SqlRowSet srs_2 = jdbcTemplateObject.queryForRowSet(sql_2);
			
			// Iterate through all results of users affiliated with the course
			while(srs_2.next())
			{
				User user = User.getSqlRowSet(srs_2);
				
				// Split Key->Value pairs from each other
				String[] perms = user.getPermission().split("||");
				
				// Iterate through all permissions the user may have
				for(String perm: perms) {
					
					// Split the Permission Key from Value. Key is CourseID -> Value is Authority level.
					String[] permHash = perm.split(":");
					
					// If the permission 'Key' is related to the course, add them based on its level. User may have multiple levels.
					if(permHash[0].equals(course.getCourseID()))
					{
						if(permHash[1].equals("2"))
						{
							instructors.add(user);
						}
						if(permHash[1].equals("1"))
						{
							tutors.add(user);
						}
						if(permHash[1].equals("0"))
						{
							students.add(user);
						}
					}
					
				} // For Each Loop
				
			} // While next user
			
			// Add the Lists of User Permission Types to the course
			course.setInstructors(instructors);
			course.setTutors(tutors);
			course.setStudents(students);
			
			return course;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Course findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean create(Course course) 
	{
		try
		{
		// READ query that checks if the Course ID already exists so no duplicates
		String sql_1 = "SELECT * FROM `studisc.courses` WHERE `COURSE_ID` = '" + course.getCourseID() + "'";
		int rows_1 = jdbcTemplateObject.update(sql_1);
		
		// Returns if any results were returned.
		if(rows_1 > 0)
		{
			return false;
		}
		
		// CREATE query that adds the course to the database
		String sql_2 = "INSERT INTO `studisc.courses` ("+ Course.getSqlParams() +") VALUES ("+ Course.getSqlValues(course) +")";
		
			// Execute SQL Insert
			int rows = jdbcTemplateObject.update(sql_2);
			
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
	public boolean update(Course t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Course t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
