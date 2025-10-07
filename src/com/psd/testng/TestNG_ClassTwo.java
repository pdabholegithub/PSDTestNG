package com.psd.testng;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_ClassTwo {
	@Test(priority = -1)
	public void login()
	{
		Assert.assertEquals(true, false);
	}
	@Test(priority = 2)
	public void logout()
	{
		Assert.assertEquals(true, true);
	}
	@Test(priority = 1)
	public void add()
	{
		Assert.assertEquals(true, true);
	}

}
