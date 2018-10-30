<link rel="stylesheet" href="css/reg.css" />

<script>
	function myFunction() {
		alert("Register Succesfull");
	}
</script>

<jsp:include page="header.jsp" />
<div id="page">


	<h1>Join Us</h1>

	<div id="wrapper" align="center">
		<form action="UserRegistration" method="post">

			<fieldset>

				<legend align="top">Register Form</legend>


				<div class="row">
					<input type="text" name="name" placeholder="Name" />
				</div>
				<br>

				<div class="row">
					<input type="text" name="lastname" placeholder="Lastname" />
				</div>
				<br>

				<div class="row">
					<input type="text" name="username" placeholder="Username" />
				</div>
				<br>

				<div class="row">
					<input type="password" name="password" placeholder="Password" />
				</div>
				<br>

				<div class="row">
					<input type="text" name="email" placeholder="Email" />
				</div>
				<br>

				<div class="row">
					<input type="text" name="phoneNumber" placeholder="PhoneNumber" />
				</div>
				<br>

				<div class="row">
					<input type="date" name="birthday" placeholder="Birthday" />
				</div>
				<br>

				<div class="row">
					<input type="text" name="gender" placeholder="Gender" />
				</div>
				<br>

				<div class="row">
					<button type="submit" value="Login" onclick="myFunction()">Register</button>
				</div>
				<br>
			</fieldset>

		</form>
	</div>

</div>

