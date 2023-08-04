package selenium.testscript;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import selenium.elementRepository.HomeLocators;
import selenium.elementRepository.TasksLocators;
import selenium.genericLib.BaseClass;

public class HiddenDivison extends BaseClass{
	@Test
	public void hiddenDivison() throws InterruptedException {
		
		HomeLocators hl=new HomeLocators(driver);
		hl.clickTasks();
		TasksLocators tl=new TasksLocators(driver);
		tl.hiddenDivisonMessage();
	}
}