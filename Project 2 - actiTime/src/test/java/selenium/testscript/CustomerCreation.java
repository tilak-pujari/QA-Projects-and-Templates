package selenium.testscript;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import selenium.elementRepository.HomeLocators;
import selenium.elementRepository.TasksLocators;
import selenium.genericLib.BaseClass;
import selenium.genericLib.CommonUtility;
import selenium.genericLib.DataUtility;

@Listeners(selenium.genericLib.ListenerImplementation.class)
public class CustomerCreation extends BaseClass {
			@Test
			public void customerCreation() throws EncryptedDocumentException, IOException {
			DataUtility du=new DataUtility();
			CommonUtility cu=new CommonUtility();
			int num=cu.getRandomNumber(10000);
			String actualcustomername=du.getDataFromExcelSheet("Sheet1",0,1);
			String description="Currently studying in QSpider!!";
			actualcustomername+=num;
	
			HomeLocators hl=new HomeLocators(driver);
			hl.clickTasks();
			
			TasksLocators tl=new TasksLocators(driver);
			String expectedname=tl.createCustomer(actualcustomername, description);
			
			AssertJUnit.assertEquals(actualcustomername, expectedname);
			Reporter.log("Test Case Passed",true);					
	}
}
