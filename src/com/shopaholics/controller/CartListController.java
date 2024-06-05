package com.shopaholics.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopaholics.beans.ProductBean;
import com.shopaholics.dao.ProductDAO;


public class CartListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException {
		try{
			HttpSession hs = request.getSession();
			String usrname = (String)hs.getAttribute("sunm");
			String id = request.getParameter("id");
			String product_name = request.getParameter("nm");
			String stock = request.getParameter("stock");
			String image = request.getParameter("file");
			int quantity = Integer.parseInt(stock);
			int price = Integer.parseInt(request.getParameter("price"));
			int offer = Integer.parseInt(request.getParameter("offer"));
			String desc = request.getParameter("desc");
			ProductDAO ud = new ProductDAO();
			ProductBean cbean = new ProductBean(id,product_name,desc,quantity, price, offer,image);
			if(usrname == null) {
				System.out.println("hi");
				response.sendRedirect("login.jsp");
			}
			int result = ud.addtocart(cbean,usrname);
			HttpSession hs2 = request.getSession();
			hs.setAttribute("uid", result);
			HttpSession hs1 = request.getSession();   
		    int cart = (Integer)hs1.getAttribute("cartno");
		    int cartno = cart + 1;
		    hs.setAttribute("cartno", cartno);
			response.sendRedirect("itemslist.jsp?uid=" + result);
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
