package excelLearning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetPractice {
	
	
	public static String ExcelTestData="C:\\Users\\admin\\eclipse-workspace\\Whatuni\\src\\main\\java\\com\\whatuni\\testdata\\excelforselenium.xlsx";

	public static Object[][] getTestData(String sheetname) throws EncryptedDocumentException, IOException {
		
		
		FileInputStream ip= new FileInputStream(ExcelTestData);
		Workbook book=WorkbookFactory.create(ip);
		Sheet sheet=book.getSheet(sheetname);
		
		
	
		
	    Object[][]	data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	    
	    for(int i=0; i<sheet.getLastRowNum();i++) {
			
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
				System.out.print(data[i][k]+" ");  
			
				
				
				}
			
			System.out.println();
			
			}
	    
		return data;
	}
	
	
	
	public void createNewSheet() throws EncryptedDocumentException, IOException {
		
		FileInputStream ip= new FileInputStream(ExcelTestData);
		Workbook book=WorkbookFactory.create(ip);
	    Sheet test=book.createSheet("Testing Engineer1");
		OutputStream fileOut = new FileOutputStream(ExcelTestData); 
		book.write(fileOut);
		
		}
	
	
	public void removeSheet(String sheetname) throws EncryptedDocumentException, IOException {
		
		FileInputStream ip= new FileInputStream(ExcelTestData);
		Workbook book=WorkbookFactory.create(ip);
		
		//System.out.println(book.getNumberOfSheets());
		 int sheetindex= book.getSheetIndex(sheetname);
		book.removeSheetAt(sheetindex);
	
	    System.out.println("sheet deleted");
		OutputStream fileOut = new FileOutputStream(ExcelTestData); 
		book.write(fileOut);
		fileOut.close();
		
	}
	
	
	public void addRow() throws EncryptedDocumentException, IOException {
		
		FileInputStream ip= new FileInputStream(ExcelTestData);
		Workbook book=WorkbookFactory.create(ip);
	    Sheet sheet=book.getSheetAt(1);
	    Row creatingRow= sheet.createRow(0);
	    creatingRow.createCell(0).setCellValue("Testing 1");
	    creatingRow.createCell(1).setCellValue("Testing 2");
	    creatingRow.createCell(2).setCellValue("Testing 3");
	    System.out.println("created row");
	    OutputStream fileOut = new FileOutputStream(ExcelTestData); 
	    book.write(fileOut);
		fileOut.close();
		
		Row row1=sheet.getRow(1);
		row1.createCell(0);
		
	}
	
public void addColumn() throws EncryptedDocumentException, IOException {
		
		FileInputStream ip= new FileInputStream(ExcelTestData);
		Workbook book=WorkbookFactory.create(ip);
	    Sheet sheet=book.getSheetAt(0);
	    
	    sheet.getRow(4).createCell(5).setCellValue("creating the cell of the column");
	    OutputStream fileOut = new FileOutputStream(ExcelTestData); 
	    book.write(fileOut);
		fileOut.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
