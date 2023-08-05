package nocommerce.testscripts;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TagsTest {

		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://demo.nopcommerce.com/");

			WebElement electronics=driver.findElement(By.xpath("//a[text()='Electronics ']"));
			Actions	act=new Actions(driver);
			act.moveToElement(electronics).perform();	
		
			//click on Camera and Photo
			WebElement cameraphoto=driver.findElement(By.xpath("//a[text()='Camera & photo ']"));
			act.click(cameraphoto).perform();	
			//click on view All
			WebElement  viewall=driver.findElement(By.xpath("//strong[text()='Popular tags']/../../div[2]/div[2]/a"));
			viewall.click();	
			
			List<WebElement> tags=driver.findElements(By.xpath("//ul[@class='product-tags-list']/li/a"));	
			for(WebElement s:tags) {
				System.out.println(s.getText());	
			}		
			
			tags.get(1).click();
		}
}
