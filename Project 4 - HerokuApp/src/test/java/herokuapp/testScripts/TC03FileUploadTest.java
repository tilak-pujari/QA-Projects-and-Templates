package herokuapp.testScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import herokuapp.pageObjects.HomePage;

public class TC03FileUploadTest {

	String path = "D:\\Eclipse Projects\\Selenium\\chromedriver.exe";
	String fileUploadPath = "D:\\dummy.txt";
	String exmsg = "File Uploaded!";
	String title = "The Internet";
	WebDriver driver;
	HomePage hp;

	@Test(priority = 1)
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp = new HomePage(driver);
	}

	@Test(priority = 2)
	public void launchWebSite() {
		driver.get("https://the-internet.herokuapp.com/");
	}

	@Test(priority = 3)
	public void clickonFileUploadBtn() {
		hp.getFileUploadLink().click();
	}

	@Test(priority = 4)
	public void fileUploadPage() throws InterruptedException {

		Assert.assertEquals(driver.getTitle(), title);
		Reporter.log("File Upload Webpage Loaded Successfully!", true);

		hp.getChoseFileBtn().sendKeys(fileUploadPath);
		hp.getUploadBtn().click();

		String msg = hp.getFileUploadMsg().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(msg.contains(exmsg));
		sa.assertAll();
		Reporter.log("File Upload Message Visible!", true);
		Thread.sleep(2000);
	}

	// @Test(priority = 4)
	public void fileUpload2() throws AWTException, InterruptedException {
		Assert.assertEquals(driver.getTitle(), title);
		Reporter.log("File Upload Webpage Loaded Successfully!", true);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(hp.getChoseFileBtn()));
		hp.getChoseFileBtn().click();

		StringSelection path = new StringSelection(fileUploadPath);
		Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
		cp.setContents(path, null);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		hp.getUploadBtn().click();

		String msg = hp.getFileUploadMsg().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(msg.contains(exmsg));
		sa.assertAll();
		Reporter.log("File Upload Message Visible!", true);
		Thread.sleep(2000);

	}

	@Test(priority = 5)
	public void closeBrowser() {
		driver.close();
	}
}