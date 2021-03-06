package com.xaccp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.xaccp.dom.SelectXml;

@SuppressWarnings("serial")
public class SelectClass extends HttpServlet {

	public SelectClass() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("----SelectClass");
		SelectXml select=new SelectXml();
		List list=select.getClassData();
		request.setAttribute("className", list);
		System.out.println(list);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	
	
	public void init() throws ServletException {
		// Put your code here
	}

}
