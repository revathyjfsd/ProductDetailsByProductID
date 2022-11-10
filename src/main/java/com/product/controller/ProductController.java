package com.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.beans.Product;
import com.product.services.ProductServices;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getAttribute("productIdAttribute").toString());
		ProductServices service = new ProductServices();
		PrintWriter out= response.getWriter();
		Product p = new Product();
		p.setId(id);
		try {
			System.out.println("Inside controller");
			p= service.getProductDetails(p);
			if(p!= null)
			{
				request.getRequestDispatcher("productDetails.html").include(request, response);
				response.setContentType("text/html; charset=utf-8");
		
				out.println("<table border=5 width=100% height=32>"
						+ "<tr>"
						+ "<th>Product Id</th>"	
				    +"<th>Product Name</th>"
				    +"<th>Product Quantity</th>"
				    +"<th>Product Price</th>"
				 +"</tr>");
				out.println("<tr>"
				   +"<td>"+p.getId()+"</td>"
				   +"<td>"+p.getName()+"</td>"
				  +"<td>"+p.getQuantity()+"</td>"
				   +"<td>"+p.getPrice()+"</td>"
				 +"</tr>");
				System.out.println("outside while loop in controller");
				out.println("</table>");
				System.out.println("after table while loop in controller");
				
			}
			else
			{
				request.getRequestDispatcher("productDetails.html").include(request, response);
				response.setContentType("text/html; charset=utf-8");
				out.print("<SPAN style= 'color:red'>"+"No records found for product Id: "+id+"</SPAN>");
			}
		} catch (Exception e) {
			request.getRequestDispatcher("productErrorPage.html").include(request, response);
			out.println("<SPAN style= 'color:red'>"+ e.getMessage()+"</SPAN><br>");
			out.println("<br>Go back to home page <a href='validate.html'><b>Home</b></a> ");
		}
	
		
		
	}

}
