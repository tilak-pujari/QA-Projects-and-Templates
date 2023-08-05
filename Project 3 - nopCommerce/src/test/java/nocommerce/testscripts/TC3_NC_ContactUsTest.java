package nocommerce.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC3_NC_ContactUsTest {
	
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
	public void contactUs() {
		WebElement contact=driver.findElement(By.linkText("Contact us"));
		contact.click();
		
		//Validation
		String contactmsg="Contact Us";
		WebElement pageinfo=driver.findElement(By.xpath("//h1[text()='Contact Us']"));
		Assert.assertEquals(contactmsg, pageinfo.getText());
		Reporter.log("Contact Us Page is Visible",true);		
	}
	
	@Test(priority=3)
	public void putContactInfo() {
		WebElement fullname=driver.findElement(By.id("FullName"));
		WebElement email=driver.findElement(By.id("Email"));
		WebElement enquiry=driver.findElement(By.id("Enquiry"));
		
		fullname.sendKeys("Captain America");
		email.sendKeys("cap@america.in");
		enquiry.sendKeys("Not Today");
		WebElement submit=driver.findElement(By.name("send-email"));
		submit.click();
		
		String replaymsg="Your enquiry has been successfully sent to the store owner.";
		String actualmsg=driver.findElement(By.className("result")).getText();
		Assert.assertEquals(replaymsg, actualmsg);
		Reporter.log("Enquiry has been Successfully sent!",true);
	}

}