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
	<jsp:include page="adminLogin.jsp" /><br>
	<br>
	<h2 align="center">Lista e Dhomave te Kerkuara</h2>
	<br>
	<div align="center">
		<form method="post">
			<table border="1">

				<tr>
					<th>Numri i dhomes</th>
					<th>Kati i Banimit</th>
					<th>Kapaciteti i Personave</th>
					<th>Çmimi per nate</th>
					<th>Kondicioner</th>
					<th>Internet</th>
					<th>Kerkuesi</th>

					<c:forEach var="i" items="${requests}">
						<tr>
							<td>${i.roomNumber}</td>
							<td>${i.kati}</td>
							<td>${i.nrPeople}</td>
							<td>${i.cmimi}</td>
							<td>${i.airConditioner}</td>
							<td>${i.internet}</td>
							<td>${i.userName} ${i.userSurname}</td>

							<td><a href="HandleRequests?Id=${i.id}&rn=${i.roomNumber}">Prano</a></td>
						</tr>

					</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>