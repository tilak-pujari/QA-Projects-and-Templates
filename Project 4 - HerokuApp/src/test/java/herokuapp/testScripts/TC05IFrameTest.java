package herokuapp.testScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import herokuapp.pageObjects.FramePage;
import herokuapp.pageObjects.HomePage;

public class TC05IFrameTest {
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
	}

	@Test(priority = 3)
	public void clickOnIFrame() {
		hp.getFrames().click();
		fp.getIframeLink().click();

		System.out.println(fp.getIframeHeaderMsg().getText());
		Assert.assertEquals(fp.getIframeHeaderMsg().getText(), headermsg);
		Reporter.log("IFrame WebPage Loaded Successfully.", true);

		driver.switchTo().frame(0);
		System.out.println(fp.getIframeBodyMsg().getText());
		Assert.assertEquals(fp.getIframeBodyMsg().getText(), bodymsg);
		Reporter.log("IFrame Successfully Loaded.", true);
	}
}