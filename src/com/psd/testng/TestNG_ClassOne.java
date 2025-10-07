package com.psd.testng;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_ClassOne {
	@Test(enabled = false,priority = -1)
	public void testcase1()
	{
		Assert.assertEquals(true, false);
	}
	@Test(priority = 1)
	public void testcase2()
	{
		Assert.assertEquals(true, false);
	}

}
