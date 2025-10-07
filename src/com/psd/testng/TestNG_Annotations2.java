package com.psd.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNG_Annotations2 {

	@Test
	public void testcase1() {
		System.out.println("Test");
	}

	@AfterClass
	public void ac() {
		System.out.println("After Class");
	}

	@AfterMethod
	public void am() {
		System.out.println("After Method");
	}

}
