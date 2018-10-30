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
	<jsp:include page="afterLogin.jsp" />

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>

	<h1>Welcome, ${username}</h1>

	<div>
		<form action="roomAlloc.jsp">
			<input type="submit" value="Alloc Room">
		</form>
	</div>

	<div>
		<form action="response.jsp">
			<input type="submit" value="See Response">
		</form>
	</div>

</body>
</html>