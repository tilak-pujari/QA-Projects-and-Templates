package herokuapp.testScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import herokuapp.pageObjects.HomePage;

public class TC01AddRemoveElementsTest {
	
	String path = "D:\\Eclipse Projects\\Selenium\\chromedriver.exe";
	WebDriver driver;

	HomePage hp;

	@Test(priority=1)
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", path);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp=new HomePage(driver);
	}
	@Test(priority=2)
	public void launchWebSite() {
		driver.get("https://the-internet.herokuapp.com/");
	}
	@Test(priority=3)
	public void clickonAddRemoveBtn() {
		hp.getAddRemoveElementsLink().click();
		Assert.assertEquals(hp.getAddElementBtn().isDisplayed(), true);
		Reporter.log("Add Remove Webpage Loaded Successfully!",true);
	}
	
	@Test(priority=4)
	public void addElements() {
		hp.getAddElementBtn().click();
		Assert.assertEquals(hp.getRemoveElementBtn().isDisplayed(), true);
		Reporter.log("Adding Elements in WebPage Working Successfully!",true);
	}
	
	@Test(priority=5)
	public void deleteElement() {
		hp.getRemoveElementBtn().click();
		Reporter.log("Removing Elements in WebPage Working Successfully!",true);
	}
}