package com.qa.utilitys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("E:\\YatraProject\\AutomationProject\\com.testautomation.selenium\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");//Providing sheetname
		int rowcount = sheet.getLastRowNum();  // returns the row count
		
		int colcount = sheet.getRow(0).getLastCellNum();  // returns the cell count
		
		for(int i=0;i<=rowcount;i++) {
			XSSFRow currentrow = sheet.getRow(i);//Focus on the current row
			
			for(int j=0;j<colcount;j++) {
				String value = currentrow.getCell(j).toString();  //read the data from cell
				System.out.print(" "+value);
			}
			System.out.println();
		}
		

	}

}
