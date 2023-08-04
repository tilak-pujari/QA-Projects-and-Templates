package herokuapp.testScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import herokuapp.pageObjects.DropdownPage;
import herokuapp.pageObjects.HomePage;

public class TC07SingleSelectDropDownTest {
	
	String path = "D:\\Eclipse Projects\\Selenium\\chromedriver.exe";
	String exmsg = "Dropdown List";
	String option1="Option 1";

	WebDriver driver;
	HomePage hp;
	DropdownPage dp;

	@Test(priority = 1)
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp = new HomePage(driver);
		dp=new DropdownPage(driver);
	}

	@Test(priority = 2)
	public void launchWebSite() {
		driver.get("https://the-internet.herokuapp.com/");
	}
	
	@Test(priority=3)
	public void clickOnDropdown() {
		hp.getDropdownLink().click();
		Assert.assertEquals(dp.getSingleDropdownMsg().getText(), exmsg);
		Reporter.log("Dropdown Page is Loaded Successfully!",true);
	}
	
	@Test(priority=4)
	public void singleSelectDropdown() throws InterruptedException {
	
		Select s=new Select(dp.getSingleSelectDropdownlink());
		s.selectByVisibleText(option1); //Select Option 1
		Thread.sleep(2000);
		s.selectByValue("2");//Select by value here value 2= Option 3
		Thread.sleep(2000);
		s.selectByIndex(1);		
	}

}
