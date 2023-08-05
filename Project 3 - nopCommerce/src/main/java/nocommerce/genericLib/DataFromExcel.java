package nocommerce.genericLib;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFromExcel {
	
	public String getDataFromExcelSheet(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("path of excelsheet");
		Workbook book=WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		Sheet sh=book.getSheet(sheetName);
		Cell cel=sh.getRow(rownum).getCell(cellnum);
		String value=format.formatCellValue(cel);
		return value;
	}
	
public String getDataFromExcelSheet(int sheetNum,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("path of excelsheet");
		Workbook book=WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		Sheet sh=book.getSheetAt(sheetNum);
		Cell cel=sh.getRow(rownum).getCell(cellnum);
		String value=format.formatCellValue(cel);
		return value;
	}

}
