<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ page isELIgnored="false" %>
</head>
<body>
	<h2>Hello World! HMS</h2>
	<h1>${totalUsers }</h1>
	<ul>
		<c:forEach var="i" items="${users}">
			<li>${i.name}</li>
		</c:forEach>
	</ul>
</body>
</html>
