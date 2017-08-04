package com.gemicle.chat.servlets.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gemicle.chat.pojo.User;
import com.gemicle.chat.service.UserService;

public class FilterConnect implements Filter {

	private Logger log = Logger.getLogger(FilterConnect.class.getName());
	private UserService servise = new UserService();
	private FilterConfig config;
	private List<String> pages;

	public FilterConnect() {
		if (pages == null) {
			pages = new ArrayList<String>();
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		HttpSession session = req.getSession();
		User user = servise.getUserFromSessionId(session.getId());

		if (user == null) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher dispatcher = config.getServletContext().getRequestDispatcher("/chat.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void destroy() {
		config = null;
	}

}
