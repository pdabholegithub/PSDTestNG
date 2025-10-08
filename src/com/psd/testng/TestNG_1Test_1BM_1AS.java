package com.psd.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_1Test_1BM_1AS {
	@BeforeMethod
	public void bm() {
		System.out.println("Before Method");
	}

	@Test
	public void testcase() {
		System.out.println("testcase");
	}

	@AfterSuite
	public void as() {
		System.out.println("After Suite");
	}

}
