package com.infogain.aspects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;

import com.infogain.beans.Product;
import com.infogain.dao.ProductDao;

@Aspect
public class ProductAspect {
@AfterReturning(pointcut = "execution(public boolean com.infogain.dao.ProductDao.updateProduct(..))", returning = "result")
public void writeLogFileSale(JoinPoint jp,Object result) throws IOException, SQLException
{
	if((Boolean)result)
	{
	Object obj[]=jp.getArgs(); 
	int pid,unitSold;
	pid=(Integer)obj[0];
	unitSold=(Integer)obj[1];
	ProductDao dbObj= new ProductDao();
	Product p=dbObj.searchProduct(pid);
	FileWriter fw= new FileWriter(new File("Product_Sale_Log.txt"),true);
	BufferedWriter bw= new BufferedWriter(fw);
	String record="[Info]: "+p.getProdName()+", "+p.getPid()+", "+unitSold+", sold on :"+new Date()+"\n";
	bw.write(record);
	bw.close();
	fw.close();
	}
	return;
}
@After("execution(public void com.infogain.dao.ProductDao.addProduct(..))")
public void writeLogFileAdd(JoinPoint jp) throws IOException
{
	Object obj[]=jp.getArgs();
	Product p =(Product)obj[0];
	FileWriter fw= new FileWriter(new File("Product_Add_Log.txt"),true);
	BufferedWriter bw= new BufferedWriter(fw);
	String record="[Info]: "+p.getProdName()+", "+p.getPid()+", "+p.getQuantityInHand()+", Added on :"+new Date()+"\n";
	bw.write(record);
	bw.close();
	fw.close();
	return;
}
@AfterThrowing(pointcut = "execution(public boolean com.infogain.beans.Product.validateQuantity(..))", throwing = "ex")
public void validate(Throwable ex) 
{
	System.out.println("Product could not be logged because : ");
	return;
}
}
