package op.testScript;

import org.testng.annotations.Test;

import op.genericLib.BaseClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;


public class UnitFeatureTest extends BaseClass{


	@Test(priority=0)
	public void checkPolicy() throws EncryptedDocumentException, IOException{
	
		driver.findElement(By.linkText("My Account")).click();
		
		driver.findElement(By.xpath("(//a[text()='Register'])[1]")).click();
		
		WebElement policy=driver.findElement(By.xpath("//input[@type='checkbox']"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(policy).click().build().perform();
		
		Reporter.log("Privacy policy link is working",true);
	}

}
