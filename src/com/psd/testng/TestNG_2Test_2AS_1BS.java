package com.psd.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_2Test_2AS_1BS {
	@AfterSuite
	public void as() {
		System.out.println("After Suite");
	}

	@AfterSuite
	public void as2() {
		System.out.println("After Suite2");
	}

	@Test
	public void testcase1() {
		System.out.println("testcase1");
	}

	@Test
	public void testcase2() {
		System.out.println("testcase2");
	}

	@BeforeSuite
	public void bs() {
		System.out.println("Before Suite");
	}

	@BeforeSuite
	public void bs1() {
		System.out.println("Before Suite1");
	}

}
