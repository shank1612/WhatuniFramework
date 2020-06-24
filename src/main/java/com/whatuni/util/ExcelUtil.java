package com.whatuni.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static Workbook book;
	public static Sheet sheet;
	public static String ExcelTestData="C:\\Users\\admin\\eclipse-workspace\\Whatuni\\src\\main\\java\\com\\whatuni\\testdata\\excelforselenium.xlsx";
	


	
	public static Object[][] getTestData(String sheetname) {
		FileInputStream ip;
		try {
			ip = new FileInputStream(ExcelTestData);
			book=WorkbookFactory.create(ip); //Accessing and going inside excel
			sheet=book.getSheet(sheetname);// Accessing the sheet 
			
			Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0; i<sheet.getLastRowNum();i++) {
				
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
					
					data[i][k]= sheet.getRow(i+1).getCell(k).toString();
					//System.out.print(data[i][k]+" ");
					
					
					}
				
				}
			
			return data;
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
		
		
		
		
	}
	
	
	
	
}
