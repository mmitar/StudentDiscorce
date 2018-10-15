<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>


<body>
	<div class="center--body">
	<h2>Add Course</h2>
	<br/>
	<form:form method="POST" modelAttribute="course" action="addedCourse">
		<table>
			<tr>
				<td><form:input class="input" path="id" placeholder="Class ID" minlength="1" maxlength="100" required="true" /></td>
			</tr>
			<tr>
				<td><form:errors class="error" path="id"/></td>
			</tr>
			<tr>
				<td><form:input class="input" path="title" placeholder="Class Title" minlength="5" maxlength="30" required="true" /></td>
			</tr>
			<tr>
				<td><form:errors class="error" path="title"/></td>
			</tr>
			<tr>
				<td><form:input class="input" path="description" placeholder="Description" minlength="5" maxlength="100" required="true" /></td>
			</tr>
			<tr>
				<td><form:errors class="error" path="description"/></td>
			</tr>
			<tr>
				<td><form:input class="input" path="major" placeholder="Major" maxlength="14" required="true" /></td>
			</tr>
			<tr>
				<td><form:errors class="error" path="major"/></td>
			</tr>
			<tr>
				<td><form:input class="input" path="classLocation" placeholder="Class Location" maxlength="30" required="true" /></td>
			</tr>
			<tr>
				<td><form:errors class="error" path="classLocation"/></td>
			</tr>
			<tr>
				<td><form:input class="input"  path="classTimes" placeholder="password" maxlength="30" required="true" /></td>
			</tr>
			<tr>
				<td><form:errors class="error" path="classTimes"/></td>
			</tr>
			<tr>
				<td><form:input class="input"  path="tutorTimes" placeholder="password" maxlength="30" required="true" /></td>
			</tr>
			<tr>
				<td><form:errors class="error" path="tutorTimes"/></td>
			</tr>
			
			<tr> 
				<td><input type="submit" value="Add Course"/></td>
				<td><a href="../login/user">Login</a></td>
			</tr>
		</table>
	</form:form>
</div>
</body>