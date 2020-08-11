package com.actitime.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib  {
	
	public String getCellData(String excelpath,String SheetName,int row ,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream(excelpath);
		               Workbook wb=WorkbookFactory.create(fis);
		             String excelval = wb.getSheet(SheetName).getRow(row).getCell(cell).toString();
		             return excelval;
		                   
	}
	
	public int getRowCount(String excelpath,String SheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(excelpath);
		               Workbook wb= WorkbookFactory.create(fis);
		                 int rowCount = wb.getSheet(SheetName).getLastRowNum();
		                 return rowCount;
			
	}
	public void setCellData(String excelpath,String SheetName,int row,int cell,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelpath);
		                   Workbook wb= WorkbookFactory.create(fis);
		                       wb.getSheet(SheetName).getRow(row).createCell(cell).setCellValue(data);         
		                   //open the writemode
		                       FileOutputStream fos=new FileOutputStream(excelpath);
		                       //save mode
		                       wb.write(fos);
		                       
	}
	
	public String getProkeyValue( String proppath, String key ) throws Throwable
	{
		FileInputStream fis=new FileInputStream(proppath);
	 Properties p=new Properties();
	 p.load(fis);
	String propvalue=p.getProperty(key, "incorrect key");
	 return propvalue;
	}
	
	

}
