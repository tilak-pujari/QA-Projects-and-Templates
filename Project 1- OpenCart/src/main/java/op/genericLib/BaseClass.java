package op.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass {
	public WebDriver driver;
	static WebDriver listenerDriver;
	DataFromProperties dp=new DataFromProperties();
	
	@BeforeClass(alwaysRun=true)
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		listenerDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	@BeforeMethod(alwaysRun=true)
	public void launchWebSite() throws IOException {
		driver.get(dp.getDataFromProperties("Url"));
		WebElement myAccount=driver.findElement(By.cssSelector("[title='My Account']"));
		myAccount.click();
		WebElement login=driver.findElement(By.linkText("Login"));
		login.click();
		driver.findElement(By.name("email")).sendKeys(
				"abcxyz@gmail.com",Keys.TAB,"abcdefg",Keys.ENTER);
		Reporter.log("login Successful",true);
	}
	
	@AfterMethod(alwaysRun=true)
	public void logout() {
		driver.findElement(By.cssSelector("[title='My Account']")).click();;
		WebElement logout=driver.findElement(By.linkText("Logout"));
		logout.click();
		Reporter.log("logout Successful",true);
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}
}