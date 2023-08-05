package nocommerce.testscripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC10_NC_ClickTagsTest {
	WebDriver driver;
	List<WebElement> tags;

	@Test(priority = 1)
	public void launch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		WebElement electronics = driver.findElement(By.xpath("//a[text()='Electronics ']"));
		Actions act = new Actions(driver);
		act.moveToElement(electronics).click().build().perform();
		WebElement viewall = driver.findElement(By.xpath("//strong[text()='Popular tags']/../../div[2]/div[2]/a"));
		viewall.click();
		tags = driver.findElements(By.xpath("//ul[@class='product-tags-list']/li/a"));
		Thread.sleep(2000);
	}

	//@Test(priority = 2)
	public void getListTags() {
		tags = driver.findElements(By.xpath("//ul[@class='product-tags-list']/li/a"));
	}

	public void launchWebPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		WebElement electronics = driver.findElement(By.xpath("//a[text()='Electronics ']"));
		Actions act = new Actions(driver);
		act.moveToElement(electronics).click().build().perform();
		WebElement viewall = driver.findElement(By.xpath("//strong[text()='Popular tags']/../../div[2]/div[2]/a"));
		viewall.click();
		Thread.sleep(2000);
	}
	@Test(invocationCount=4)
	public void clickTag() throws InterruptedException {
		for (int i = 0; i < tags.size(); i++) {
			tags.get(i).click();
			System.out.println(tags.get(i).getText() + "is Working");
			break;
		//	launchWebPage();
		}
	}
}