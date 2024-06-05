package com.shopaholics.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopaholics.beans.SellerBean;
import com.shopaholics.dao.SellerDAO;


/**
 * Servlet implementation class SellerLController
 */
public class SellerLController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 try {
		//read user and password		
		String name = request.getParameter("user");
		String pwd = request.getParameter("password");
		
		/*//create object of BussinessUtility class
		
		BussinessUtility utils = new BussinessUtility();
		//call validateUser() method
	boolean result = utils.validateUser(name, pwd);
		//redirecting control to welcome or login*/
		
		//creating ContactBean object with parameterized constructor
		SellerBean uBean = new SellerBean(name, pwd);
		SellerDAO ud = new SellerDAO();
		boolean result = ud.validateUser(uBean);
		if(result)
		{
			//get http Session reference
			HttpSession hs = request.getSession();
			//add name as session attribute
			hs.setAttribute("sunm", name);
			response.sendRedirect("productslist.jsp?username="+name);									
			
		}
		else
		{
			response.sendRedirect("LSeller.jsp?username="+name);
			
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}