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

public class TC8_NC_ElectronicsTest {
	
	WebDriver driver;
	Actions act;
	
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
	}
	public void closeBrowser() {
		driver.close();
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
	
	@Test(priority=3)
	public void testCameraPhoto(){
		launchApplication();
		navigateElectronics();
		
		WebElement cameraphoto=driver.findElement(By.xpath("//a[text()='Camera & photo ']"));
		act.click(cameraphoto).perform();
		
		//validation
		String pageTitle="nopCommerce demo store. Camera & photo";
		Assert.assertEquals(pageTitle,driver.getTitle());
		Reporter.log("Camera & photo Page is Working fine",true);
		
		List<WebElement> allProducts=driver.findElements(By.xpath("//div[@class='products-container']/div[2]/div[1]/div[1]/div/div[1]/div[2]/h2"));
		getDetails(allProducts);
		
		closeBrowser();
	}
	
	@Test(priority=4)
	public void testCellphones() {
		launchApplication();
		navigateElectronics();
		
		WebElement cellphone=driver.findElement(By.xpath("//a[text()='Cell phones ']"));
		act.click(cellphone).perform();
		
		//validation
		String pageTitle="nopCommerce demo store. Cell phones";
		Assert.assertEquals(pageTitle,driver.getTitle());
		Reporter.log("Cell phones Page is Working fine",true);
		
		List<WebElement> allProducts=driver.findElements(By.xpath("//div[@class='products-container']/div[2]/div[1]/div[1]/div/div[1]/div[2]/h2"));
		getDetails(allProducts);
		closeBrowser();
	}
	
	@Test(priority=5)
	public void testOthers() {
		launchApplication();
		navigateElectronics();
		
		WebElement other=driver.findElement(By.xpath("//a[text()='Others ']"));
		act.click(other).perform();
		
		//validation
		String pageTitle="nopCommerce demo store. Others";
		Assert.assertEquals(pageTitle,driver.getTitle());
		Reporter.log("Others Page is Working fine",true);
		
		List<WebElement> allProducts=driver.findElements(By.xpath("//div[@class='products-container']/div[2]/div[1]/div[1]/div/div[1]/div[2]/h2"));
		getDetails(allProducts);
		closeBrowser();
	}
}