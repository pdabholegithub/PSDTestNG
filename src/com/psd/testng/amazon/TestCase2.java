package com.psd.testng.amazon;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestCase2 extends LaunchQuit {
	@Test
	public void login_searching_logout() throws InterruptedException {

		System.out.println("Writing script for just searching");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Shoe");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
	}

}
