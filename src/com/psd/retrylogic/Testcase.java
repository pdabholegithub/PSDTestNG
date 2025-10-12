package com.psd.retrylogic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testcase {
	@Test(retryAnalyzer = com.psd.retrylogic.RetryLogic.class)
	public void yahoosearch() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.yahoo.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.name("pp")).sendKeys("Yahoo...");
		driver.findElement(By.name("pp")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.quit();

	}

}
