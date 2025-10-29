package com.psd.excelsheet.program;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingValuesFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream f1 = new FileInputStream("C:\\Users\\prasad.dabhole\\eclipse-workspace\\PSDTestNG\\Excel Sheet\\DDT.xlsx");
		Workbook w1 = WorkbookFactory.create(f1);
		Sheet s1 = w1.getSheet("login");
		Row r1 = s1.getRow(1);
		Cell c1 = r1.getCell(0);
		String un = c1.getStringCellValue();
		System.out.println(un);

	}

}
