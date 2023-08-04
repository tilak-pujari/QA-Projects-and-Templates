package herokuapp.testScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import herokuapp.pageObjects.HomePage;

public class TC08HorizontalSliderTest {
	
	String path = "D:\\Eclipse Projects\\Selenium\\chromedriver.exe";
	String exmsg = "Congratulations! You must have the proper credentials.";
	String title = "The Internet";
	WebDriver driver;
	HomePage hp;

	@Test(priority = 1)
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp = new HomePage(driver);
	}

	@Test(priority = 2)
	public void launchWebSite() {
		driver.get("https://the-internet.herokuapp.com/");
	}
	
	

}
