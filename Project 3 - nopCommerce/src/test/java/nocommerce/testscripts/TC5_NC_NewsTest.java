package nocommerce.testscripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC5_NC_NewsTest {

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
	public void registerNew() {
		
		List<WebElement> allnews=driver.findElements(By.xpath
				("//strong[text()='News']/../../div[2]/div/div[2]"));
		List<WebElement> allnewstitle=driver.findElements(By.xpath
				("//strong[text()='News']/../../div[2]/div/div[1]"));
		
		for(int i=0;i<allnewstitle.size();i++) {
			System.out.println(allnewstitle.get(i).getText()
					+"\n"+allnews.get(i).getText());
		}
	}
	@Test(priority=3)
	public void getNews() {
		//click on news Archieve
		driver.findElement(By.className("view-all")).click();
		
		List<WebElement> allnews=driver.findElements(By.xpath
				("//h1[text()='News']/../../div/div/div/div[1]/a[1]"));
		List<WebElement> allnewstitle=driver.findElements(By.xpath
				("//h1[text()='News']/../../div/div/div/div[2]"));
		
		for(int i=0;i<allnewstitle.size();i++) {
			System.out.println(allnewstitle.get(i).getText()
					+"\n"+allnews.get(i).getText());
		}
	}

}
