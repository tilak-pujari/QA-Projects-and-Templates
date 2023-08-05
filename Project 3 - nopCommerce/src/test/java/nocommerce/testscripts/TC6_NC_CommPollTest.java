package nocommerce.testscripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC6_NC_CommPollTest {
	
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
	public void testCommunityPoll() {
		WebElement excellent=driver.findElement(By.xpath("//ul[@class='poll-options']/li[1]/input[1]"));
		WebElement good=driver.findElement(By.xpath("//ul[@class='poll-options']/li[2]/input[1]"));
		WebElement poor=driver.findElement(By.xpath("//ul[@class='poll-options']/li[3]/input[1]"));
		WebElement verybad=driver.findElement(By.xpath("//ul[@class='poll-options']/li[4]/input[1]"));
		
		excellent.click();
		good.click();
		poor.click();
		verybad.click();
	}
	
	@Test(priority=3)
	public void testSocialMedia() {
		List<WebElement> ref=driver.findElements(By.xpath("//strong[text()='Follow us']/../../ul/li/a"));
		for(WebElement social:ref) {
			System.out.println(social.getText());
		}	
	}

}
