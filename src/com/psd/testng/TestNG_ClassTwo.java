package com.psd.testng;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_ClassTwo {
	@Test
	public void login()
	{
		Assert.assertEquals(true, false);
	}
	@Test
	public void logout()
	{
		Assert.assertEquals(true, true);
	}
	@Test
	public void add()
	{
		Assert.assertEquals(true, true);
	}

}
