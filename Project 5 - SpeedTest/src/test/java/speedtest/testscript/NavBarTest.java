package speedtest.testscript;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import speedtest.elementRepository.HomeLocators;
import speedtest.genericLib.BaseClass;
import speedtest.genericLib.CommonUtility;

public class NavBarTest extends BaseClass{
	List<WebElement> navmenu;
	CommonUtility cu=new CommonUtility();
	HomeLocators hl;
	@Test(priority=1)
	public void homeLogoclick() {
		hl=new HomeLocators(driver);
		hl.getHomeLogo().click();
		Reporter.log("HomeLogo Button Working");
	}
	@Test(priority=2)
	public void navBarMenuIcons() {
		hl=new HomeLocators(driver);
		List<WebElement> navmenu=hl.getNavmenu();
		for(WebElement link:navmenu) {	
		String list=link.getText();
		System.out.println(list);
		}
		Reporter.log("All Navigation Bar Components Visible");
	}	
	
	@Test(priority=3)
	public void hoverNavBar() throws InterruptedException {
		hl=new HomeLocators(driver);
		List<WebElement> navmenu=hl.getNavmenu();
		for(WebElement link:navmenu) {	
		cu.moveCursonOnElements(driver, link);
		}
		Reporter.log("All Navigation Bar Components Hovered");
	}
	
	@Test(priority=4)
	public void chekRunFunction() throws IOException {
		hl=new HomeLocators(driver);
		hl.getStartRun().click();;
		hl.getResult();
		hl.waitAMinute(driver, hl.getResult(), hl.getResultwait().getText());
		cu.takeScreenshot(hl.getResult());
		Reporter.log("Run Test Button Working");
	}

}
