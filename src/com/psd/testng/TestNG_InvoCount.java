package com.psd.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_InvoCount {
	@Test(invocationCount = 10, priority = -1)
	public void testcase1() {
		Assert.assertEquals(true, true);
	}

}
