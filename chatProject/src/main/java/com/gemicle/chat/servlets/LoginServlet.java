package com.gemicle.chat.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gemicle.chat.pojo.User;
import com.gemicle.chat.service.UserService;
import com.gemicle.chat.validators.ValidatorLogin;
import com.mysql.fabric.Response;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String EMPTY = "";
	private Logger log = Logger.getLogger(LoginServlet.class.getName());
	private ValidatorLogin validator = new ValidatorLogin();
	private UserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("user");
		String mail = request.getParameter("mail");
		String pwd = request.getParameter("pwd");

		if (name.isEmpty() || mail.isEmpty() || pwd.isEmpty()) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		} else {
			response.addCookie(new Cookie("user", name));
			response.addCookie(new Cookie("mail", mail));
			response.addCookie(new Cookie("pwd", pwd));
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10*60);
			
			User user = new User();
			user.setLogin(request.getParameter("user"));
			user.setMail(request.getParameter("mail"));
			user.setPassword(request.getParameter("pwd"));
			user.setSessionId(session.getId());
			user.setDateCreate(new Date());
			user.setId(service.save(user));

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/chat.jsp");
			rd.include(request, response);
			
			log.info(user.toString());
		}

	}
}
