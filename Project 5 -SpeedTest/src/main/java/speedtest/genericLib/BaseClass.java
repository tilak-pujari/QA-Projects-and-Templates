package speedtest.genericLib;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver listenerDriver;
	
	@BeforeClass
	public void launchBrowser() {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications-");
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
		driver=new ChromeDriver(opt);
		listenerDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod
	public void openWebApplication() {
		driver.get("https://www.speedtest.net/");
	}
	@AfterMethod
	public void closeWebApplication() {
		
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	

}
