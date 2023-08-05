package nocommerce.genericLib;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {
	
	//Get Random Number
	public int getRandom(int range) {
		Random r=new Random();
		int num=r.nextInt(range);
		return num;
	}
	
	//Dropdown Select
	public void selectByIndex(WebElement wb,int index) {
		Select s=new Select(wb);
		s.selectByIndex(index);
	}
	
	public void selectByValue(WebElement wb,String value) {
		Select s=new Select(wb);
		s.selectByValue(value);
	}
	
	public void selectByVisibleText(WebElement wb,String visibleText) {
		Select s=new Select(wb);
		s.selectByVisibleText(visibleText);
	}
	
	
	//Dropdown DeSelect
	public void deselectByIndex(WebElement wb,int index) {
		Select s=new Select(wb);
		s.deselectByIndex(index);
	}
	
	public void deselectByValue(WebElement wb,String value) {
		Select s=new Select(wb);
		s.deselectByValue(value);
	}
	public void deselectByVisibleText(WebElement wb,String visibleText) {
		Select s=new Select(wb);
		s.deselectByVisibleText(visibleText);
	}
	
	public void deSelectAll(WebElement wb) {
		Select s=new Select(wb);
		s.deselectAll();
	}
	
	
	//Alert Pop-Up Handling
	public void alertAccept(WebDriver driver) {
		Alert al=driver.switchTo().alert();
		al.accept();
	}
	
	public void alertSendKeys(WebDriver driver,String value) {
		Alert al=driver.switchTo().alert();
		al.sendKeys(value);
	}
	
	public String alertGetText(WebDriver driver) {
		Alert al=driver.switchTo().alert();
		return al.getText();
	}
	
	public void alertCancel(WebDriver driver) {
		Alert al=driver.switchTo().alert();
		al.dismiss();
	}
	
	
	//Scroll Functions
	public void scrollToWebElement(WebDriver driver,WebElement wb) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",wb);	
	}
	
	public void scrollToXY(WebDriver driver,int x,int y) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+x+","+y+");");
	}
	public void scrollToVertical(WebDriver driver,int y) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+y+");");
	}
	
	public void scrollToHorizontal(WebDriver driver,int x) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+x+",0);");
	}
	
	
	public static void main(String[] args) {
		CommonUtility cu=new CommonUtility();
		int num=cu.getRandom(1000);
		System.out.println(num);
	}

}