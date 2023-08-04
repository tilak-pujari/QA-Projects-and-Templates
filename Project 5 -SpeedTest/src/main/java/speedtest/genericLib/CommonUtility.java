package speedtest.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonUtility {
	
	public int getRandom(int range) {
		Random r=new Random();
		int num=r.nextInt(range);
		return num;
	}

	public void takeScreenshot(WebElement wb) throws IOException {
		String name="TC"+getRandom(1000);
		File src=wb.getScreenshotAs(OutputType.FILE);
		File trg=new File("./screenshot/"+name+".png/");
		FileUtils.copyFile(src, trg);
	}
	
	public void moveCursonOnElements(WebDriver driver,WebElement wb) throws InterruptedException {
	Actions act=new Actions(driver);
	act.moveToElement(wb).perform();
	Thread.sleep(2000);//for visibility
	}
	

}
