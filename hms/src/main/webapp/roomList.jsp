<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ page isELIgnored="false"%>
</head>
<body>
	<jsp:include page="afterLogin.jsp" /><br> Totali i dhomave:
	${totalRooms}
	<br>

	<h2>Lista e Dhomave</h2>
	<br>

	<table border="1">

		<tr>
			<th>ID</th>
			<th>Kati i Banimit</th>
			<th>Kapaciteti i Personave</th>
			<th>Çmimi per nate</th>
			<th>Kondicioner</th>
			<th>Internet</th>
			<th>Rezervuar</th>
		</tr>

		<c:forEach var="i" items="${rooms}">
			<tr>
				<td>${i.id}</td>
				<td>${i.kati}</td>
				<td>${i.nrPeople}</td>
				<td>${i.cmimi}</td>
				<td>${i.airConditioner}</td>
				<td>${i.internet}</td>
				<td>${i.occupied}</td>
				<td> <a href = "editRoom.jsp?Id=${i.id}">Edit</a></td>
			</tr>

		</c:forEach>

	</table>
	<br>

	<br>
	<form action="addRoom.jsp" method="post">
		<input type="submit" value="Add Room">
	</form>

</body>
</html>