package com.psd.testng.crossbrowser.testing;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase3 extends TestNG_CrossBrowser{
	@Test
	public void login_searching_cart_logout() throws InterruptedException {

		System.out.println("Writing script for just searching and adding it to cart");

		WebElement e1 = driver.findElement(By.id("twotabsearchtextbox"));
		e1.sendKeys("Shoe" + Keys.ENTER);
		WebElement e2 = driver.findElement(By.xpath("(//a[@class = 'a-link-normal s-no-outline'])[1]"));
		e2.click();
		// First id of parent & second of child
		// System.out.println(driver.getWindowHandles());
		Set<String> id = driver.getWindowHandles();
		Iterator<String> i1 = id.iterator();
		String parentid = i1.next();
		String childid = i1.next();
		System.out.println(parentid);
		System.out.println(childid);
		driver.switchTo().window(childid);
		WebElement e3 = driver.findElement(By.id("add-to-cart-button"));
		e3.click();

		Thread.sleep(7000);
	}

}
