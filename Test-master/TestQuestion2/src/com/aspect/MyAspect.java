package com.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.exception.LoginException;

@Aspect
public class MyAspect {

	@AfterThrowing(pointcut="execution(public void login(..))",throwing="ex")
	public void displayException(LoginException ex)
	{	
		System.out.println("aspect execute after throwing "+ex);	
	}
	@After("execution(public void showTrains())")
	public void trains()
	{
		System.out.println("No More Trains Available");
	}
	
	/*@After("execution(public void login(..))")
	public void trainsextra()
	{
		System.out.println("No More Trains Available");
	}*/
	
}
