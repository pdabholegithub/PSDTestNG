package com.psd.testng;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Skip_Testcases {
	@Test
	public void login() {
		Assert.assertTrue(true);

	}

	@Test(dependsOnMethods = "login")
	public void logout() {

	}

}
