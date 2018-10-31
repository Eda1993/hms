<!DOCTYPE html>
<html>
<jsp:include page="afterLogin.jsp" />
<style>
fieldset {
	display: inline-block;
}
</style>

<body>
	<div>
		<form>

<pre></pre>
			<fieldset>

				<legend>Ploteso</legend>
				<p>Check-in</p>
				<form action="demo_form.asp">
				
					<input type="date" name="checkIn"> 
					<input type="checkbox" name="airconditioner" value="Air conditioner">Air condition 
					<input type="checkbox" name="internet" value="Internet">Internet
					<br> <br>


					<p>Check-out</p>
					<form action="demo_form.asp">
						<input type="date" name="checkOut"> <br> <br>
						<br> <select id="1" name="AdultSelector">

							<option value="1 adult" selected="true">1 adult</option>
							<option value="2 adult">2 adult</option>
							<option value="3 adult">3 adult</option>
							<option value="4 adult">4 adult</option>
							<option value="5 adult">5 adult</option>
							<option value="6 adult">6 adult</option>

						</select> <br>
						<br> <select name="ChildrenSelector">
							<option value="1 child" selected="true">1 child</option>
							<option value="2 child">2 child</option>
							<option value="3 child">3 child</option>
							<option value="4 child">4 child</option>
							<option value="5 child">5 child</option>
							<option value="6 child">6 child</option>


						</select> <select name="RoomSelector">
							<option value="1  room" selected="true">1 room</option>
							<option value="2 room">2 room</option>
							<option value="3 room">3 room</option>
							<option value="4 room">4 room</option>
							<option value="5 room">5 room</option>
							<option value="6 room">6 room</option>


						</select> <br>
						<br> <input type="submit" value="Book">
			</fieldset>
		</form>
	</div>
</body>
</html>