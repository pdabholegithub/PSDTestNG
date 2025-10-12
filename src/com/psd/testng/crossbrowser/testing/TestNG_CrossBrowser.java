package com.psd.testng.crossbrowser.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestNG_CrossBrowser {
	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void launch(String nameofbrowser) {

		if (nameofbrowser.equals("chrome")) {
			System.out.println("Launching Chrome Browser");
			driver = new ChromeDriver();
		}
		if (nameofbrowser.equals("firefox")) {
			System.out.println("Launching Firefox Browser");

			driver = new FirefoxDriver();
		}
		if (nameofbrowser.equals("edge")) {
			System.out.println("Launching Edge Browser");

			driver = new EdgeDriver();
		}

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void quit() {
		System.out.println("Logout & Closing Browser");
		driver.quit();

	}

}
