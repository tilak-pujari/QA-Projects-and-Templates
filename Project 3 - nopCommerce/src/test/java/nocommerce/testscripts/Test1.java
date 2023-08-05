package nocommerce.testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import nocommerce.elementocators.HomePage;

public class Test1 {
	HomePage hp;
	WebDriver driver;
	
	@Test(priority=0)
	public void launchApplication() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse Projects\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp=new HomePage(driver);
	}
	@Test(priority=1)
	public void launchNoCommerce() throws InterruptedException {
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test(priority=99)
	public void closeBrowser() {
		driver.quit();
	}
	@Test(priority=2)
	public void clickLogo() {
		hp.getHomelogo().click();
	}
	@Test(priority=3)
	public void registerButton() {
		hp.getRegisterBtn().click();
	}
	@Test(priority=4)
	public void wishListButton() {
		hp.getWishListBtn().click();
	}
	
	@Test(priority=5)
	public void loginButton() {
		hp.getLoginBtn().click();
	}
}