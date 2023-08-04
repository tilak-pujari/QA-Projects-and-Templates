package selenium.testscript;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import selenium.elementRepository.HomeLocators;
import selenium.elementRepository.TypeOfWorkLocators;
import selenium.genericLib.BaseClass;
import selenium.genericLib.CommonUtility;

public class AlertPopup extends BaseClass{
	@Test
	public void alertPopup() throws EncryptedDocumentException, IOException {
	
		HomeLocators hl=new HomeLocators(driver);
		hl.clicktSettings();
		hl.clickTypeOfWork();
		
		TypeOfWorkLocators tow=new TypeOfWorkLocators(driver);
		tow.alertPopUp(du.getDataFromExcelSheet("Sheet1",0,1));
		
		CommonUtility cu=new CommonUtility();
		String msg=cu.getAlertMessage(driver);
		System.out.println(msg);
		cu.cancelAlert(driver);
	}

}

