package com.techhelpline.exceptionsdemo;

import org.testng.annotations.Test;

public class TestNGExceptionHandling {

	//here we are creating one method which is throwing exception
	// so let's get handle it by declaring exception
	@Test (expectedExceptions=ArithmeticException.class)
	public void testException()
	{
		System.out.println("In Test Exception Mathod!!!!");
		
		// so guys to throw exception we need to fail test case
		
		int i=1/0;
		
	}
}
