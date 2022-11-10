package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.product.beans.Product;
import com.product.dbUtil.DbUtility;


public class ProductDAO {
	
	public Product getProductDetails(Product p) throws ClassNotFoundException, SQLException
	{
		System.out.println("Inside DAO");
		Connection conn= DbUtility.dBConn();
		System.out.println("after calling connection");
		if(conn!=null)
		{
			System.out.println("Connection successful");
		}
		else
		{
			System.out.println("Connection failed");
		}
		String sql="select * from product where productId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, p.getId());
		ResultSet rs = ps.executeQuery();
		System.out.println("After query exceution");
		Product pr= new Product();
		while(rs.next())
		{
			pr.setId(rs.getInt(1));
			pr.setName(rs.getString(2));
			pr.setQuantity(rs.getInt(3));
			pr.setPrice(rs.getFloat(4));
		}
		conn.close();
		if(pr.getId()!=0)
		{
			System.out.println("In dao"+pr.toString());
			return pr;
		}
		else {
			return null;
		}
		
		
	}

}
