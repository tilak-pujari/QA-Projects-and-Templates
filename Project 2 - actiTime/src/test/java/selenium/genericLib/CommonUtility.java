package selenium.genericLib;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {
	public int getRandomNumber(int range) {
		Random r=new Random();
		int num=r.nextInt(range);
		return num;
		}
	//Alert PopUp Handling
	public String getAlertMessage(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		String msg=alt.getText();
		return msg;
	}
	public void cancelAlert(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	public void acceptAlert(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	public void sendValueToAlert(WebDriver driver,String value) {
		Alert alt=driver.switchTo().alert();
		alt.sendKeys(value);
	}
	
	//Select Class Handling
	
	public void selectByVisibleText(WebElement wb,String visibleText) {
		Select s=new Select(wb);
		s.selectByVisibleText(visibleText);
	}
	
	public void selectByValue(WebElement wb,String value) {
		Select s=new Select(wb);
		s.selectByValue(value);
	}
	public void selectByIndex(WebElement wb,int index) {
		Select s=new Select(wb);
		s.selectByIndex(index);
	}



}
