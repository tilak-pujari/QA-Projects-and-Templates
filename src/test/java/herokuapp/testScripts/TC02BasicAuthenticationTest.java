package herokuapp.testScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import herokuapp.dataUtilites.DataProperties;
import herokuapp.pageObjects.HomePage;

public class TC02BasicAuthenticationTest {

	String path = "D:\\Eclipse Projects\\Projects\\chromedriver.exe";
	String exmsg = "Congratulations! You must have the proper credentials.";
	String title = "The Internet";
	WebDriver driver;
	HomePage hp;
	DataProperties dp = new DataProperties();

	@Test(priority = 1)
	public void launchBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse Projects\\Projects\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp = new HomePage(driver);
	}

	@Test(priority = 2)
	public void launchWebSite() throws IOException {
		driver.get(dp.getDataFromPropertiesFile("Url"));
	}

	// @Test(priority = 3)
	public void clickonBasicAuthBtn() {
		hp.getBasicAuthLink().click();
	}

	// @Test(priority = 4)
	public void basicAuth() {
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		clickonBasicAuthBtn();
		Assert.assertEquals(driver.getTitle(), title);
		Reporter.log("Basic Authentication Webpage Loaded Successfully!", true);
		String msg = hp.getBasicAuthMsg().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(msg.contains(exmsg));
		sa.assertAll();
		Reporter.log("Basic Authentication Message Visible!", true);
	}
}