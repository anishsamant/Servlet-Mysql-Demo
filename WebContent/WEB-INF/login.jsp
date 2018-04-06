<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container">
		<form method="post" action="validate">
			<label>User</label><br>
			<input type="text" name="username"><br><br>

			<label>Password</label><br>
			<input type="Password" name="pass"><br><br>

			<input type="submit" name="" id="subbtn">
	</form>
		<a href="register.jsp"><h3>Login</h3></a>
	</div>

</body>
</html>