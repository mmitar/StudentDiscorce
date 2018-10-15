<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<body>

<c:choose>
	<c:when test="${not empty course}">
<div class="course-container">

	<div class="course--content">
	
	content ${course.id}
		<div class="course--header">
			
			<img src="<c:url value="${course.image}"/>" alt="Picture" height="200px">
			<img src="https://www.csuci.edu/img/launch-virtual-tour-16x9.jpg" alt="Picture" height="200px">
			
			<div class="course--id">
				${course.id}
			</div>
			<div class="course--major">
				${couse.major}
			</div>
		</div>
		<div class="course--time">
			time start
		
		</div>
		
	</div>
	
	<div class="course--users">
		
		<h3>Instructors:</h3>
		<hr/>
		<br/>Tim<br/>
		<br>
		<h3>Tutors:</h3>
		<hr/>
		<br/>Tom<br/>
		<h3>Students:</h3>
		<hr/>
		<br>Tam<br/>
		
	</div>

</div>

	</c:when>
	<c:otherwise>
	
	Class Does not exist
	</c:otherwise>

</c:choose>


</body>