package nocommerce.testscripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC9_NC_TagsTest {
	WebDriver driver;
	Actions act;
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
	}
	public void getDetails(List<WebElement> allElements) {
		for(WebElement s:allElements) {
			System.out.println(s.getText());	
		}	
	}
	public void navigateElectronics() {
		WebElement electronics=driver.findElement(By.xpath("//a[text()='Electronics ']"));
		act=new Actions(driver);
		act.moveToElement(electronics).perform();	
	}
	@Test(priority=1)
	public void getAllProductTags(){
		launchApplication();
		navigateElectronics();
		//click on Camera and Photo
		WebElement cameraphoto=driver.findElement(By.xpath("//a[text()='Camera & photo ']"));
		act.click(cameraphoto).perform();		
		WebElement  viewall=driver.findElement(By.xpath("//strong[text()='Popular tags']/../../div[2]/div[2]/a"));
		viewall.click();		
		List<WebElement> tags=driver.findElements(By.xpath("//ul[@class='product-tags-list']/li/a"));	
		getDetails(tags);	
		driver.quit();
	}
}