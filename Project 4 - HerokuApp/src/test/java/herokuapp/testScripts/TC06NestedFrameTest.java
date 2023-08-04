package herokuapp.testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import herokuapp.pageObjects.FramePage;
import herokuapp.pageObjects.HomePage;

public class TC06NestedFrameTest {

	String path = "D:\\Eclipse Projects\\Selenium\\chromedriver.exe";
	WebDriver driver;

	HomePage hp;
	FramePage fp;
	String headermsg = "An iFrame containing the TinyMCE WYSIWYG Editor";
	String bodymsg = "Your content goes here.";

	@Test(priority = 1)
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp = new HomePage(driver);
		fp = new FramePage(driver);
	}

	@Test(priority = 2)
	public void launchWebSite() {
		driver.get("https://the-internet.herokuapp.com/");
		hp.getFrames().click();
		fp.getNestedFrameLink().click();
	}

	@Test(priority = 3)
	public void bottomIFrame() {
		// Get Message from Bottom Frame
		driver.switchTo().frame(fp.getBottomIframe());
		System.out.println(driver.findElement(By.tagName("body")).getText());
		// to move up to main page
		driver.switchTo().defaultContent();
	}

	@Test(priority = 4)
	public void topRightIFrame() {
		// go to top frame
		driver.switchTo().frame(fp.getTopIframe());
		// Get Message from right Frame
		driver.switchTo().frame(fp.getTopRightIframe());
		System.out.println(driver.findElement(By.tagName("body")).getText());
		// to move upto previous frame
		driver.switchTo().parentFrame();
	}

	@Test(priority = 5)
	public void topMiddleIFrame() {
		// Get Message from top middle Frame
		driver.switchTo().frame(fp.getTopMiddleIframe());
		System.out.println(driver.findElement(By.tagName("body")).getText());
		driver.switchTo().parentFrame();
	}

	@Test(priority = 6)
	public void topLeftIFrame() {
		// Get Message from top left Frame
		driver.switchTo().frame(fp.getTopLeftIframe());
		System.out.println(driver.findElement(By.tagName("body")).getText());
		driver.switchTo().parentFrame();
	}
}