package com.infogain.main;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infogain.aspects.ProductStockInHand;
import com.infogain.beans.Product;
import com.infogain.dao.ProductDao;

public class ProductManagementSystem {
public static void main(String[] args) throws ProductStockInHand {
	int choice;
	Scanner in=new Scanner(System.in);
	ProductManagementSystem obj=new ProductManagementSystem();
	while(true)
	{
		System.out.println("Enter Choice \n 1.Add Product \t "
				                         + "2.Sale Product \t "
				                         + "3.Exit");
		choice=Integer.parseInt(in.nextLine());
		switch(choice)
		{
		case 1:obj.addProduct();
			break;
		case 2:obj.saleProduct();
			break;
		case 3:System.exit(0);
			break;
			default:System.out.println("Invalid Choice");
		}
	}
	
}
public void addProduct() throws ProductStockInHand
{
	Scanner in=new Scanner(System.in);
	int id,cost,quantity;
	String name;
	System.out.println("Enter product id : ");
	id=Integer.parseInt(in.nextLine());
	System.out.println("Enter product name : ");
	name=in.nextLine();
	System.out.println("Enter product cost : ");
	cost=Integer.parseInt(in.nextLine());
	System.out.println("Enter product quantity in hand : ");
	quantity=Integer.parseInt(in.nextLine());
	ApplicationContext ctx=new ClassPathXmlApplicationContext("com/infogain/res/spring_config.xml");
	ProductDao obj=ctx.getBean("productDB",ProductDao.class);
	Product p=ctx.getBean("p1",Product.class);
	p.setPid(id);
	p.setProdName(name);
	p.setProdCost(cost);
	p.setQuantityInHand(quantity);
	try {
		obj.addProduct(p);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public void saleProduct()
{
	int id,sold;
	Scanner in=new Scanner(System.in);
	System.out.println("Enter product id : ");
	id=Integer.parseInt(in.nextLine());
	System.out.println("Enter unit sold : ");
	sold=Integer.parseInt(in.nextLine());
	ApplicationContext ctx=new ClassPathXmlApplicationContext("com/infogain/res/spring_config.xml");
	ProductDao obj=ctx.getBean("productDB",ProductDao.class);
	try {
		Product p=obj.searchProduct(id);
		if(p.validateQuantity())
		{
			obj.updateProduct(id, sold);
			System.out.println("Updated");
		}
	} catch (Exception e) {
		System.out.println(e);
	}
}
}
