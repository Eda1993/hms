<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="adminLogin.jsp" />
	<link rel="stylesheet" href="css/reg.css" />

	<form action="AddRoom" method="post">
		<fieldset>

			<legend align="top">Plotesoni te dhenat</legend>
			Numri i dhomes: <input type="number" name="roomNr"><br>
			Kati i banimit: <input type="number" name="kati"><br>
			Kapaciteti i personave: <input type="number" name="nrPeople"><br>
			�mimi per nate: <input type="int" name="cmimi"><br>
			<!--Kondicioner: <input type="checkbox" checked="checked" name="ac" value="ac"/><br>  -->
			<!-- Internet: <input type="checkbox" checked="checked" name="net" value="net"/><br> -->

			Kondicioner: <input type="number" name="ac"><br>
			Internet: <input type="number" name="net"><br> <input
				type="submit" value="Add">
		</fieldset>
	</form>
</body>
</html>