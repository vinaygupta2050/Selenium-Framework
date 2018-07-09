package com.test.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@DataProvider(name="excelDataProvider")
	public Object[][] allExcelData() throws IOException
	{
		String xlFilePath = "D:\\Test.xlsx"; //Replace with your local Test excelsheet
		String sheetName="Sheet1";
		Object[][] data = testData(xlFilePath,sheetName);
		return data;
	}
	
	public Object[][] testData(String xlFilePath,String sheetName) throws IOException
	{
		Object[][] excelData =null;
		ExcelReader excelReader = new ExcelReader(xlFilePath);
		int rows = excelReader.getRowCount(sheetName);
		int columns = excelReader.getColumnCount(sheetName);
		
		excelData = new Object[rows-1][columns];
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				excelData[i-1][j] = excelReader.getCellData(sheetName, i, j);
			}
		}
		return excelData;
		
	}
}
