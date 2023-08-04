package op.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import op.genericLib.BaseClass;
@Test(priority=2,enabled=false)
public class LogoutTest extends BaseClass {
	LoginTest lt=new LoginTest();
	WebElement logout;
	public void logoutFunction() {
		lt.loginFunction();
			driver.findElement(By.cssSelector("[title='My Account']")).click();;
			logout=driver.findElement(By.linkText("Logout"));
			logout.click();
			Reporter.log("logout Successful",true);
		}
}
