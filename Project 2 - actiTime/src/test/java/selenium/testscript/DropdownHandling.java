package selenium.testscript;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import selenium.elementRepository.GeneralSettingsLocators;
import selenium.elementRepository.HomeLocators;
import selenium.genericLib.BaseClass;
import selenium.genericLib.CommonUtility;

public class DropdownHandling extends BaseClass{
	
	@Test
	public void dropdownHandle() {
		CommonUtility cu=new CommonUtility();
		HomeLocators hl=new HomeLocators(driver);
		hl.clicktSettings();
		hl.clickGeneralSettings();
		
		GeneralSettingsLocators gs=new GeneralSettingsLocators(driver);
		gs.DropdownHandling();
		cu.selectByVisibleText(gs.getNameFirstDD(), "Product");
		String msg=gs.dropDownMessage();
		System.out.println(msg);


	}
}
