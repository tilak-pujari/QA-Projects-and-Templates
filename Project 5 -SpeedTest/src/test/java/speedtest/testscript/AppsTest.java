package speedtest.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import speedtest.elementRepository.HomeLocators;
import speedtest.genericLib.BaseClass;

public class AppsTest extends BaseClass {
	public WebDriver driver;
	HomeLocators hl;
	@Test(priority=1)
	public void AppsPageTest() {
		
		hl=new HomeLocators(driver);
		hl.clickApps();
//		driver.findElement(By.cssSelector("[aria-label='Close']")).click();
//		driver.findElement(By.xpath("//a[text()='Apps']")).click();	
	}

}
