package nocommerce.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC13_LogoTest {
	WebDriver driver;
	
	public void openNopCommerce() {
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Projects\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		Reporter.log("Nop Commerce Webpage is Launched",true);
	}
	
	@Test(priority=9)
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Browser is Closed",true);
		
	}
	
	@Test(priority=1)
	public void testVisibleLogo() {
		openNopCommerce();
		WebElement logo=driver.findElement(By.className("header-logo"));
		Assert.assertEquals(true, logo.isDisplayed());
		Reporter.log("Logo is Visible in WebPage",true);
	}
	@Test(priority=2)
	public void testPlaceDigitalDownload() {
		WebElement digitalDown=driver.findElement(By.xpath("//h2[@class='title']/../../../div[3]/div[1]/h2[1]/a[1]"));
		Rectangle rec=digitalDown.getRect();
		//Given Width=388 Height=41 X=965 Y=990	rec.getWidth();388	rec.getHeight();41		rec.getX();965		rec.getY();990		
		Dimension d=new Dimension(388,41);
		System.out.println(digitalDown.getSize());
		Assert.assertEquals(d, digitalDown.getSize());
		Reporter.log("The Height and Width of WebELement are Correct",true);
		
		Point p=new Point(965,990);
		System.out.println(digitalDown.getLocation());
		Assert.assertEquals(p,digitalDown.getLocation());
		Reporter.log("The X and Y Coordinates of WebELement are Correct",true);
		
		digitalDown.click();
	}
	@Test(priority=3)
	public void testLogoClickable() {
		WebElement logo=driver.findElement(By.className("header-logo"));
		logo.click();
		Reporter.log("Header Icon is Clickable",true);
		
	}
}