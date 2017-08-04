<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Chat page</title>
</head>
<body>
	<h1>Chat</h1>
	<%
		Cookie[] cookies = request.getCookies();
		String name = "";
		String sessionId = "";
		for (Cookie cookie : cookies) {
			String cookieName = cookie.getName();
			if (cookieName.equals("user")) {
				name = cookie.getValue();
				continue;
			} else if (cookieName.equals("JSESSIONID")) {
				sessionId = cookie.getValue();
			}
		}
	%>
	<h3>
		Hi
		<%=name%>! Your session id
		<%=sessionId%></h3>
	<br>
	<p>
		<br>
	<form action="<%=response.encodeURL("LogoutServlet")%>" method="post">
		<input type="submit" value="Logout">
</form></p>
	
</body>
</html>