package op.genericLib;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFromExcel {
		
		public String getDataFromExcelBy(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\OpenCart\\Testdata.xlsx");
			Workbook book=WorkbookFactory.create(fis);
			Sheet sh=book.getSheet(sheetName);
			DataFormatter format=new DataFormatter();
			String value=format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
			return value;
		}
		
		public String getDataFromExcelBy(int sheetNum,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\OpenCart\\Testdata.xlsx");
			Workbook book=WorkbookFactory.create(fis);
			Sheet sh=book.getSheetAt(sheetNum);
			DataFormatter format=new DataFormatter();
			String value=format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
			return value;
		}
		
		public void getAllDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\OpenCart\\Testdata.xlsx");
			Workbook book=WorkbookFactory.create(fis);
			Sheet sh=book.getSheet("Sheet1");
			DataFormatter format=new DataFormatter();
			for(int i=0;i<=sh.getLastRowNum();i++) {
				Row row=sh.getRow(i);
				for(int j=0;j<=row.getLastCellNum();j++) {
					String value=format.formatCellValue(row.getCell(j));
					System.out.print(value+" ");
				}
				System.out.println();
			}
		}

}
