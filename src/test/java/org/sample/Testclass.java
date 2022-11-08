package org.sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


public class Testclass {

	@BeforeClass
	public static void beforeclas() {
		System.out.println("Testclass beforeclass");
	}
	
	@AfterClass
	public static void afterclass() {
		System.out.println("Testclass afterclass");
	}
	
	@Test
	public void test1() {
		System.out.println("Testclass test1 method");
	}
}
