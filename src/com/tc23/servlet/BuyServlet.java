package com.tc23.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc23.daoimpl.UserDaoImpl;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		Cookie[] cookies = req.getCookies();
		String username = null;
		String password  =null;
		for (int i = 0;cookies!=null &&i < cookies.length; i++ ) {
			if("username".equals(cookies[i].getName())) {
				username = cookies[i].getValue();										
			}
			if("password".equals(cookies[i].getName())) {
				password = cookies[i].getValue();
			}
		}		
		if (session!= null&&"admin".equals(username)&&"1234".equals(password)) {
			int i = new UserDaoImpl().buyGoods(id);
			if (i==1) {
				pw.write("购买成功!<br>");
				pw.write("<a href='index.jsp'>返回主页</a>");
			}
			if (i==0) {
				pw.write("购买失败!!<br>");
				pw.write("<a href='index.jsp'>返回主页</a>");
			}
		} else {
			resp.sendRedirect("index.jsp");
		}

	}
}
