package nocommerce.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC2_NC_AboutUsTest {
	WebDriver driver;
	@Test(priority=1)
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test(priority=2)
	public void clickOnAboutUs() {
		WebElement about=driver.findElement(By.linkText("About us"));
		about.click();
		
		//Validation
		String aboutmsg="About us";
		WebElement pageinfo=driver.findElement(By.xpath("//h1[text()='About us']"));
		Assert.assertEquals(aboutmsg, pageinfo.getText());
		Reporter.log("About Page is Visible",true);		
	}

}
