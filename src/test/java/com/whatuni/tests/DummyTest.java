package com.whatuni.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;


//import com.whatuni.util.WhatuniConstants;

import excelLearning.ExcelSheetPractice;

public class DummyTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		
		ExcelSheetPractice excel=new ExcelSheetPractice();
		//excel.getTestData(WhatuniConstants.CONTACTS_SHEET_NAME);
		//excel.createNewSheet();
		//excel.removeSheet("Testing Engineer");
		//excel.addRow();
		excel.addColumn();

	}

}
