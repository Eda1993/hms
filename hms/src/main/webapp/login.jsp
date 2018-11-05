
<jsp:include page="header.jsp" />

<style>
#1, #2 {
	width: 100px;
	height: 100px;
	border: 1px solid red;
	margin-right: 10px;
}

.wrapper {
	float: right;
	margin-right: 5px;
}

#search {
	width: 20em;
	height: 2em;
}
</style>

<div id="1">

	<h1 align="center">5 STARS Premium Hotel</h1>
	<div id="3">
		<img alt="photo" src="images/welcome.jpeg" width="800" height="450"
			align="left">
	</div>
</div>

<div id="2">
	<div class="wrapper" align="center">
	
		<link rel="stylesheet" href="css/reg.css" />
		
		<form class="form-signin" method="post" action="LoginController">
			<fieldset>

				<legend align="top">Please Login</legend>

				<input type="text" class="form-control" name="username"
					placeholder="Username" required="" autofocus="" /><br> <input
					type="password" class="form-control" name="password"
					placeholder="Password" required="" />

				<div class="row">
					<select name="loginSelector">
						<option value="user">User</option>
						<option value="admin">Admin</option>
					</select>
				</div>
				<br>
				<button type="submit" id="search" value="LOGIN" class="search">Login</button>
				<br>
				<br>
			</fieldset>
		</form>
	</div>
</div>



