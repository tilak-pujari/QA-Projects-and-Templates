package op.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import op.genericLib.BaseClass;
@Test(priority=1,enabled=false)
public class LoginTest extends BaseClass {
	WebElement myAccount;
	WebElement login;

	public void loginFunction() {
		myAccount=driver.findElement(By.cssSelector("[title='My Account']"));
		myAccount.click();
		login=driver.findElement(By.linkText("Login"));
		login.click();
		driver.findElement(By.name("email")).sendKeys(
				"abcxyz@gmail.com",Keys.TAB,"abcdefg",Keys.ENTER);
		Reporter.log("login Successful",true);
	}


}
