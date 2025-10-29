package com.psd.excelsheet.program;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTWithDataProviderAnnotations {

	@DataProvider(name = "logindetails")
	public Object[][] getLoginData() throws IOException {
		String excelPath = "C:\\Users\\prasad.dabhole\\eclipse-workspace\\PSDTestNG\\Excel Sheet\\DDT.xlsx";
		String sheetName = "login";

		// Read Excel file
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);

		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[totalRows - 1][totalCols]; // Skip header row

		for (int i = 1; i < totalRows; i++) { // start from row 1 to skip header
			Row row = sheet.getRow(i);
			for (int j = 0; j < totalCols; j++) {
				Cell cell = row.getCell(j);
				data[i - 1][j] = getCellValue(cell);
			}
		}

		workbook.close();
		fis.close();

		return data;
	}

	@Test(dataProvider = "logindetails")
	public void fblogin_twodimentional(String username, String password) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.quit();
	}

	// Helper method to safely get cell value
	private static String getCellValue(Cell cell) {
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return NumberToTextConverter.toText(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		default:
			return "";
		}
	}
}
