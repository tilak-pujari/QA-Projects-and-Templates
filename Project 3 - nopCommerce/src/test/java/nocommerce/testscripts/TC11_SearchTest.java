package nocommerce.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC11_SearchTest {
	WebDriver driver;

	@Test(priority = 1)
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
	}

	// @Test(priority=2)
	public void testSearchButton() {
		WebElement search = driver.findElement(By.linkText("Search"));
		search.click();

		WebElement searchfield = driver.findElement(By.id("q"));
		searchfield.sendKeys("phone");
		searchfield.submit();
	}

	@Test(priority = 3)
	public void testAdvancedSearch() {

		WebElement search = driver.findElement(By.linkText("Search"));
		search.click();

		WebElement searchfield = driver.findElement(By.id("q"));
		searchfield.sendKeys("phone");
		
		WebElement advancedsearch = driver.findElement(By.xpath("//label[text()='Advanced search']"));
		advancedsearch.click();
		WebElement catId = driver.findElement(By.id("cid"));
		WebElement manufacturerId = driver.findElement(By.xpath("//div[@class='advanced-search']/div[3]/select"));

		Select s = new Select(catId);
		s.selectByVisibleText("All");

		Select s1 = new Select(manufacturerId);
		s1.selectByVisibleText("HP");

		WebElement search2 = driver.findElement(By.xpath("//div[@class='buttons']/button"));
		search2.click();
		
		/*WebElement item=driver.findElement(By.className("product-item"));
		if(item.isDisplayed()) {
			System.out.println("Test Case Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
		*/
		String opt1="No products were found that matched your criteria.";
		String noresult=driver.findElement(By.className("no-result")).getText();
		if(opt1.equals(noresult)){
			System.out.println("No Items were TC Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
		System.out.println(opt1.equals(noresult)?"TC Passed":"TC Failed");
	}

}