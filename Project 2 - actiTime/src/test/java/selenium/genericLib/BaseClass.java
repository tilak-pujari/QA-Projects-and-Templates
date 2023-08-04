package selenium.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import selenium.elementRepository.HomeLocators;
import selenium.elementRepository.LoginLocators;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver listenerDriver;
	public DataUtility du = new DataUtility();
	public HomeLocators hl;

	@BeforeClass(alwaysRun = true)
	public void launchBrowser() {
		driver = new ChromeDriver();
		listenerDriver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException {
		driver.get(du.getDataFromProperties("Url"));
		LoginLocators ll = new LoginLocators(driver);
		ll.loginApp(du.getDataFromProperties("Username"), du.getDataFromProperties("Password"));
	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		hl = new HomeLocators(driver);
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}

}

/*
 * CROSS BROWSER TESTING
 * 
 * @Parameters("browser")
 * 
 * @BeforeClass(alwaysRun=true) public void launchBrowser(String browser) {
 * if(browser.equals("chrome")) { System.setProperty("webdriver.chrome.driver",
 * "C:\\Users\\91740\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe"
 * ); driver=new ChromeDriver(); } else if(browser.equals("edge")) {
 * System.setProperty("webdriver.edge.driver",
 * "C:\\Users\\91740\\OneDrive\\Desktop\\Selenium\\edgedriver_win64\\msedgedriver.exe"
 * ); driver=new EdgeDriver(); }
 * 
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 * driver.manage().window().maximize(); }
 */