package com.infogain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infogain.beans.Product;


public class ProductDao {
	private DataSource datasource;

	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public ProductDao()
	{}
	public ProductDao(DataSource datasource) {
		super();
		this.datasource = datasource;
	}

	public void addProduct(Product p) throws  SQLException 
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/infogain/res/spring_config.xml");
		Connection con=ctx.getBean("productDB",ProductDao.class).getDatasource().getConnection();
		String query="insert into product values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, p.getPid());
		ps.setString(2, p.getProdName());
		ps.setInt(3, p.getProdCost());
		ps.setInt(4, p.getQuantityInHand());
		int i=ps.executeUpdate();
	}

	public Product searchProduct(int pid) throws BeansException, SQLException 
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/infogain/res/spring_config.xml");
		Connection con=ctx.getBean("productDB",ProductDao.class).getDatasource().getConnection();
		Product p=ctx.getBean("p1",Product.class);
		String query="select * from product where pid=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, pid);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			p.setPid(pid);
			p.setProdName(rs.getString(2));
			p.setProdCost(rs.getInt(3));
			p.setQuantityInHand(rs.getInt(4));
			return p;
		}
		return null;
	}

	public boolean updateProduct(int pid, int unitSold) throws BeansException, SQLException 
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/infogain/res/spring_config.xml");
		Connection con=ctx.getBean("productDB",ProductDao.class).getDatasource().getConnection();
		String query="update product set QuanityInHand=QuanityInHand-? where pid=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, unitSold);
		ps.setInt(2, pid);
		int i=ps.executeUpdate();
		if(i>0)
			return true;
		else
		return false;
	}

	@Override
	public String toString() {
		return "ProductDao [datasource=" + datasource + "]";
	}
	
}
