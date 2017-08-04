<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Authorization page</title>
</head>
<body>
	<h1>Authorization</h1>
	<form action="LoginServlet" method="post">
		<p>
			<b>Login:</b><br> <input type="text" name="user" size="40">
		</p>

		<p>
			<b>Mail:</b><br> <input type="mail" name="mail" size="40">
		</p>

		<p>
			<b>Password:</b><br> <input type="password" name="pwd" size="40">
		</p>

		<p>
			<input type="submit" value="Login">
		</p>
	</form>
</body>
</html>