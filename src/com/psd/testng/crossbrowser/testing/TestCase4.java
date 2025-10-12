package com.psd.testng.crossbrowser.testing;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestCase4 extends TestNG_CrossBrowser {
	@Test
	public void login_searching_logout() throws InterruptedException {

		System.out.println("Writing script for just searching");
		Thread.sleep(3000);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Shoe");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
	}

}
