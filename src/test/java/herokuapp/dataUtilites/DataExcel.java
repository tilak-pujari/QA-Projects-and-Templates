package herokuapp.dataUtilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataExcel {
	String path="D:\\Eclipse Projects\\Projects\\testdata\\commondata.xlsx";
	
	public String getDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(sh.getRow(rowNum).getCell(cellNum));		
		return value;
	}
	
	
	public String getDataFromExcelFile(int sheetNum,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheetAt(sheetNum);
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(sh.getRow(rowNum).getCell(cellNum));		
		return value;
	}

}