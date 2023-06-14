package herokuapp.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	String path = "D:\\Eclipse Projects\\Selenium\\chromedriver.exe";
	WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", path);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void launchWebSite() {
		driver.get("https://the-internet.herokuapp.com/");
	}
	
	@AfterMethod
	public void logout() {
		
	}
	public void closeBrowser() {
		driver.close();
	}
}