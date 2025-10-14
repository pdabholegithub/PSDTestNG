package com.psd.testng.amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonLogin_Assertion {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
	}

	@Test
	public void verifyAmazonLogin() throws InterruptedException {
		// Click on “Sign in” from Account & Lists
		WebElement signInBtn = driver.findElement(By.id("nav-link-accountList"));
		signInBtn.click();

		// Enter email / mobile
		driver.findElement(By.id("ap_email_login")).sendKeys("9730911185");
		driver.findElement(By.id("continue")).click();

		// Enter password
		driver.findElement(By.id("ap_password")).sendKeys("1234");
		driver.findElement(By.id("signInSubmit")).click();

		// Wait for page to load after login
		Thread.sleep(4000);

		// Capture the greeting text (e.g., "Hello, Prasad")
		String actualGreeting = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();

		// Expected text (update with your actual account greeting)
		String expectedGreeting = "Hello, Prasad";

		// Assertion
		Assert.assertEquals(actualGreeting, expectedGreeting,
				"❌ Login verification failed! Expected greeting did not match.");

		System.out.println("✅ Test Passed: Amazon login successful and greeting matched!");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
