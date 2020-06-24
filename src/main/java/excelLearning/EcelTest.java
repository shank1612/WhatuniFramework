package excelLearning; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import org.apache.poi.ss.usermodel.Sheet; 
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
  
public class EcelTest { 
    public static void main(String[] args)  throws FileNotFoundException, IOException 
    { 
  
        // Creating Workbook instances 
        Workbook wb = new XSSFWorkbook(); 
  
        // An output stream accepts output bytes and sends them to sink. 
        OutputStream fileOut = new FileOutputStream("Geeks1.xlsx"); 
          
        // Creating Sheets using sheet object 
        Sheet sheet1 = wb.createSheet("Array"); 
        Sheet sheet2 = wb.createSheet("String"); 
        Sheet sheet3 = wb.createSheet("LinkedList"); 
        Sheet sheet4 = wb.createSheet("Tree"); 
        Sheet sheet5 = wb.createSheet("Dynamic Programing"); 
        Sheet sheet6 = wb.createSheet("Puzzles"); 
          
  
System.out.println("Sheets Has been Created successfully"); 
  
        wb.write(fileOut); 
    } 
} 