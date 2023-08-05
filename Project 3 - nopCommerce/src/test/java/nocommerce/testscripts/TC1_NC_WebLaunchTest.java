package nocommerce.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC1_NC_WebLaunchTest {
	public WebDriver driver;
	
	@Test(priority=1)
	public void testLaunch() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://demo.nopcommerce.com/");
			
			
			String title="nopCommerce demo store";
			Assert.assertEquals(title,driver.getTitle());
			Reporter.log("WebPage is Launching Successfully",true);
			
	}
	
	@Test(priority=2)
	public void checkLogo() {
		WebElement logo=driver.findElement(By.className("header-logo"));
		Assert.assertEquals(logo.isDisplayed(), true);
		Reporter.log("Logo is Visible in WebSite",true);
	}

}
