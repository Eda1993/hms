
<jsp:include page="header.jsp" />
<div id="page">

	<div>
		<img alt="photo" src="images/welcome.jpeg" align="middle">
	</div>
	<pre>
	<div class="wrapper" align="center">
	
		<form class="form-signin" method="post" action="LoginController">
			<h2 class="form-signin-heading">Please login</h2>

			<input type="text" class="form-control" name="username"
					placeholder="Username" required="" autofocus="" /><br>
			<input type="password" class="form-control" name="password"
					placeholder="Password" required="" />
					
			<div class="row">
				<select name="loginSelector">
					<option value="user">User</option>
					<option value="admin">Admin</option>
				</select>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
				<br><br>
		</form>
	</div>
	</pre>
</div>

