package com.product.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ProductValidationFilter
 */
public class ProductValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ProductValidationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String productId= request.getParameter("productId").strip();
		System.out.println("In filter " +productId);
		if(productId.matches("[0-9]+"))
		{
			request.setAttribute("productIdAttribute", productId);
			System.out.println("valide product id " +productId);
			chain.doFilter(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("validate.html").include(request, response);
			out.print("<SPAN style= 'color:red'>Invalid Product ID. Non digit value entered</SPAN>");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
