package com.gemicle.chat.servlets;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gemicle.chat.service.UserService;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UserService service = new UserService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
			}
		}
		
		HttpSession session = request.getSession();
		if(session != null){
			service.delete(service.getUserFromSessionId(session.getId()));
			session.invalidate();
		}
		
		response.sendRedirect("/login.jsp");
		
	}
}
