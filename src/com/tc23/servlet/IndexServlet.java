package com.tc23.servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tc23.bean.Goods;
import com.tc23.daoimpl.UserDaoImpl;

public class IndexServlet extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<Goods> goodList = new UserDaoImpl().queryGood();			
			req.setAttribute("goodList", goodList);
		}
		
		
}