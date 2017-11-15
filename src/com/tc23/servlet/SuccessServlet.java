package com.tc23.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/success")
public class SuccessServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);	
		String pretime = "";
		Cookie[] cookies = req.getCookies();		
		for (int i = 0;cookies!=null &&i < cookies.length; i++ ) {
			if("time".equals(cookies[i].getName())) {
				pretime = cookies[i].getValue();										
			}
		}		
		if (session!=null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd~HH:mm:ss");// 设置日期格式
			String time = df.format(new Date());// new Date()为获取当前系统时间
			Cookie lastime = new Cookie("time", time);
			lastime.setMaxAge(Integer.MAX_VALUE);
			resp.addCookie(lastime);			
			String name = (String)session.getAttribute("name");		
			pw.write(name+"登录成功!<br>");
			pw.write("上次登陆时间:"+pretime+"<br>");
			pw.write("<a href='index.jsp'>返回主页</a>");
		}else {
			resp.sendRedirect("index.jsp");
		}
	}
}
