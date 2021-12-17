package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/**
	 * This method used to read data from excel by specifying sheetname,row number and cell number
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	
	public String getExcelData(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream file=new FileInputStream(IpathContact.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		return cell.getStringCellValue();
	}
	/**
	 * This method return all the data in the sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	
	//same script with multiple data 
	public Object[][] getExcelData(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		FileInputStream file=new FileInputStream(IpathContact.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		int lastrow = sheet.getLastRowNum();
		short lastcell = sheet.getRow(0).getLastCellNum();
		Object[][]data = new Object[lastrow][lastcell];
		for(int i=0; i<lastrow; i++)
		{
			for(int j=0; j<lastcell;j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
      /**
       * This method used to write the data inside the Excel sheet
       * @param sheetName
       * @param rownum
       * @param column
       * @param value
     * @throws IOException 
     * @throws InvalidFormatException 
     * @throws EncryptedDocumentException 
       */


      public void WriteExcelData(String sheetName,int rownum,int column,String value) throws EncryptedDocumentException, InvalidFormatException, IOException
      {
    	  FileInputStream file=new FileInputStream(IpathContact.EXCELPATH);
    	  Workbook workbook=WorkbookFactory.create(file);
    	  workbook.createSheet(sheetName).createRow(rownum).createCell(column).setCellValue(value);
    	  FileOutputStream writefile=new FileOutputStream(IpathContact.EXCELPATH);
    	  workbook.write(writefile);
      }
}


