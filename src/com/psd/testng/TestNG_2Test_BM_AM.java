package com.psd.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_2Test_BM_AM {
	@Test
	public void testcase1() {
		System.out.println("testcase1");
	}

	@Test
	public void testcase2() {
		System.out.println("testcase2");
	}

	@BeforeMethod
	public void bm() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void am() {
		System.out.println("After Method");
	}

}
