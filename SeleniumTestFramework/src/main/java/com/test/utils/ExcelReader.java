package com.test.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public FileInputStream fis =null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell=null;
	String xlFilePath;
	
	public ExcelReader(String xlFilePath) throws IOException
	{
		this.xlFilePath=xlFilePath;
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}
	
	public int getRowCount(String sheetName)
	{
		sheet=workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()+1;
		return rowCount;
	}
	
	public int getColumnCount(String sheetName)
	{
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		return columnCount;
	}
	
	public String getCellData(String sheetName, int i,int j)
	{
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(i);
		cell= row.getCell(j);
		if(cell.getCellTypeEnum()==CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		else if(cell.getCellTypeEnum()==CellType.BLANK)
		{
			return "";
		}
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
		{
				return String.valueOf(cell.getNumericCellValue());
		}
		else
		{
			return String.valueOf(cell.getBooleanCellValue());
		}
		}
}
	

