package com.psd.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestNG_BS_AS_AM {

	@AfterMethod
	public void am() {
		System.out.println("After Method");
	}

	@BeforeSuite
	public void bs() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public void as() {
		System.out.println("After Suite");
	}

}
