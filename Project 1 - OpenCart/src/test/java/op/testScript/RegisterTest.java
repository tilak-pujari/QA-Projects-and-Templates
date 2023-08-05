package op.testScript;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


import op.genericLib.BaseClass;

@Listeners(op.genericLib.ListenerImplementation.class)
public class RegisterTest extends BaseClass {
	
	public WebDriverWait wait;
	String expect="Your Account Has Been Created!";
	
	@Test(priority=1 ,enabled=false)
	public void registration() throws InterruptedException {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(By.linkText("My Account")).click();
		
		driver.findElement(By.xpath("(//a[text()='Register'])[1]")).click();
		WebElement fname=driver.findElement(By.id("input-firstname"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
		
		fname.sendKeys("abc",Keys.TAB,"xyz",Keys.TAB,"abcxyz6@gmail.com",
				Keys.TAB,"1234512345",Keys.TAB,"abcdefg",Keys.TAB,"abcdefg",
				Keys.TAB,Keys.TAB);

		WebElement policy3=driver.findElement(By.xpath("//input[@type='checkbox']"));
		Actions act=new Actions(driver);
		act.moveToElement(policy3).click().build().perform();
		fname.sendKeys(Keys.ENTER);
		
		String actual=driver.findElement(By.xpath("//div[@class='row']/div[1]/h1")).getText();
		AssertJUnit.assertEquals(actual,expect);
		System.out.println("Test Case Passed");
		Reporter.log("Registration Functionality is Working as Expected",true);
	}
}