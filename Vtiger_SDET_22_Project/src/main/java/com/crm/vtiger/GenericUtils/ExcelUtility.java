package com.crm.vtiger.GenericUtils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author ARIJIT
 *
 */
public class ExcelUtility {
	/**
	 * This method used to read data from excel by specifing sheetname, row number and cell number
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		return cell.getStringCellValue();
	
	}
	
	/**
	 * This method return all the data or multiple data in the sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] getExcelData(String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream file=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		short lastCell = sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		}
	
	/**
	 * This method is used to write data inside the excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param column
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeExcelData(String sheetname,int rownum,int column,String value) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(file);
		workbook.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
		FileOutputStream writeFile=new FileOutputStream(IPathConstant.EXCELPATH);
		workbook.write(writeFile);
	}


}
