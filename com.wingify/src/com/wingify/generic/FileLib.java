package com.wingify.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FileLib {

	public String getPropertyData(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
		
	}
	
	public String getexcelData(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream f=new FileInputStream("C:\\Users\\tamil\\eclipse-workspace\\com.wingify\\data\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		String un= wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return un;
		
	}
	
	public void setexcelData(String sheet, int row, int cell,String val) throws EncryptedDocumentException, IOException
	{
		FileInputStream f=new FileInputStream("C:\\Users\\tamil\\eclipse-workspace\\com.wingify\\data\\Testdata.xlsx");
		org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(f);
		 wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(val);
		
		FileOutputStream fos=new FileOutputStream("./data/testscript.xlsx");
		wb.write(fos);
		wb.close();
	}
}
