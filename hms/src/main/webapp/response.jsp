<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ page isELIgnored="false"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="userLogin.jsp" /><br>
	<ul>
		<c:forEach var="i" items="${pendingRequests}">
			<li>${i}</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="i" items="${acceptedRequests}">
			<li>${i}</li>
		</c:forEach>
	</ul>

	<ul>
		<c:forEach var="i" items="${rejectedRequests}">
			<li>${i}</li>
		</c:forEach>
	</ul>
</body>
</html>