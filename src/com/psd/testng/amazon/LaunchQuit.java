package com.psd.testng.amazon;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LaunchQuit {
	ChromeDriver driver;

	@BeforeMethod
	public void launch() {
		System.out.println("Launching Browser");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void quit() {
		System.out.println("Logout & Closing Browser");
		driver.quit();

	}

}
