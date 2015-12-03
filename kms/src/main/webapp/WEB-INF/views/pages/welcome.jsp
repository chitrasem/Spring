<%@ include file="/WEB-INF/views/base.jspf" %>
<html>
<head>
	<title>Welcome page</title>
</head>
<body>
	Dear <strong>${user}</strong>, Welcome to Home Page. 
	<a href="<c:url value="/logout" />">Logout</a>

	<br/>
	<br/>
	<div>
		<label>View all information| This part is visible to Everyone</label>
	</div>

	<br/>
	<div>
		<sec:authorize access="hasRole('TEACHER')">
			<label><a href="#">Edit this page</a> | This part is visible only to ADMIN</label>
		</sec:authorize>
	</div>

	<br/>
	<div>
		<sec:authorize access="hasRole('DIRECTOR') and hasRole('DBA')">
			<label><a href="#">Start backup</a> | This part is visible only to one who is both ADMIN & DBA</label>
		</sec:authorize>
	</div>
</html>