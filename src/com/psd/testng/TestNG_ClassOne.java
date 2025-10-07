package com.psd.testng;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_ClassOne {
	@Test
	public void testcase1()
	{
		Assert.assertEquals(true, false);
	}

}
