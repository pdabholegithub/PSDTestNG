package com.psd.excelsheet.program;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingValuesFromExcel2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream f1 = new FileInputStream("C:\\Users\\prasad.dabhole\\eclipse-workspace\\PSDTestNG\\Excel Sheet\\DDT.xlsx");
		Workbook w1 = WorkbookFactory.create(f1);
		String un1 = NumberToTextConverter.toText(w1.getSheet("login").getRow(2).getCell(0).getNumericCellValue());
		//String un = w1.getSheet("login").getRow(2).getCell(0).getStringCellValue();		
		System.out.println(un1);
		String pwd1 = NumberToTextConverter.toText(w1.getSheet("login").getRow(2).getCell(1).getNumericCellValue());
		//String pwd = w1.getSheet("login").getRow(2).getCell(1).getStringCellValue();
		System.out.println(pwd1);
		System.out.println("This is my username:" + un1 + " This is my password:" + pwd1);
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys(un1);
		driver.findElement(By.name("pass")).sendKeys(pwd1);
		driver.findElement(By.name("login")).click();
	}

}
