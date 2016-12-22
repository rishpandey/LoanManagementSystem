package com.rprt.lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rprt.lms.beans.User;

/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("HiddenField").equals("1")){
	
			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("password", request.getParameter("password"));
			getServletContext().getRequestDispatcher("/LoginFilter").forward(request, response);
		
		}	
		if(request.getParameter("HiddenField").equals("2")){
			
			request.setAttribute("firstname", request.getParameter("firstname"));
			request.setAttribute("password", request.getParameter("password"));
			request.setAttribute("emailid", request.getParameter("emailid"));
			request.setAttribute("number", request.getParameter("number"));
			request.setAttribute("security", request.getParameter("security"));
			request.setAttribute("answer", request.getParameter("answer"));
			
			getServletContext().getRequestDispatcher("/RegisterFilter").forward(request, response);
		
		}
	}

}
