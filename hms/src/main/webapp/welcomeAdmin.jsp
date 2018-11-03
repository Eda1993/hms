<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ page isELIgnored="false"%>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<jsp:include page="adminLogin.jsp" />
	<h2 align="center">Welcome, ${user.name}</h2>

	<h3>List of registered people</h3>

	<table border="1">

		<tr>
			<th>Name</th>
			<th>Last Name</th>
			<th>Username</th>
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
				<td>${i.email}</td>
				<td>${i.phoneNumber}</td>
				<td>${i.birthday}</td>
				<td>${i.gender}</td>
			</tr>
		</c:forEach>

	</table>
	<pre></pre>

</body>
</html>
