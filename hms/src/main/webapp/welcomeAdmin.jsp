<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ page isELIgnored="false"%>
</head>
<body>

	<jsp:include page="afterLogin.jsp" />
	<h2>Welcome, ${username}</h2>


	<table border="1">

		<tr>
			<th>Name</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>Password</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Birthday</th>
			<th>Gender</th>
		</tr>

		<c:forEach var="i" items="${users}">
			<tr>
				<td>${i.name}</td>
				<td>${i.lastname}</td>
				<td>${i.username}</td>
				<td>${i.password}</td>
				<td>${i.email}</td>
				<td>${i.phoneNumber}</td>
				<td>${i.birthday}</td>
				<td>${i.gender}</td>
			</tr>
		</c:forEach>

	</table>
	<pre></pre>
	<pre>
	<div>
		<form action="RoomInfo">
			<input type="submit" value="View Rooms">
		</form>
	</div>

	<div>
		<form action="Requests">
			<input type="submit" value="View Requests">
		</form>

	</div>
	</pre>
</body>
</html>
