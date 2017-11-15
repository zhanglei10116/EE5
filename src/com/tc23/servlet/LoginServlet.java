package com.tc23.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("username");
	String pwd = req.getParameter("pwd");
	if(name!=null&&pwd!=null) {
	if ("admin".equals(name) && "1234".equals(pwd)) {		
		String id = req.getSession().getId();
		Cookie cookie = new Cookie("JSESSIONID", id);
		cookie.setMaxAge(60*15);
		Cookie username = new Cookie("username", name);
		username.setMaxAge(60*15);
		Cookie password = new Cookie("password", pwd);
		password.setMaxAge(60*15);
		resp.addCookie(cookie);
		resp.addCookie(username);
		resp.addCookie(password);
		req.getSession().setMaxInactiveInterval(60*15);
		req.getSession().setAttribute("name", name);
		resp.sendRedirect("success");
	} else {				
		resp.sendRedirect("index.jsp");
	}
}
}
}
