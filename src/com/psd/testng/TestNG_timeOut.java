package com.psd.testng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNG_timeOut 
{
	@Test(timeOut = 10000)
	public void testcase1() 
	{
		ChromeDriver driver = new ChromeDriver();
	}

}
