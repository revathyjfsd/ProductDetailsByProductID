package com.product.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.product.beans.Product;
import com.product.dao.ProductDAO;

public class ProductServices{
	
	public Product getProductDetails(Product p) throws Exception
	{
		
		try {
			ProductDAO dao = new ProductDAO();
			p=dao.getProductDetails(p);
		}catch(ClassNotFoundException cnFE)
		{
			throw new Exception("Error occured while connecting to backend: " +cnFE);
		}
		catch(SQLException s)
		{
			throw new Exception("Error occured in backend: "+s);
		}
		catch(Exception e)
		{
			throw new Exception("Unexpected Error occurred: "+e);
		}
		return p;
	}

}
