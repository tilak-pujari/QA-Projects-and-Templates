package selenium.elementRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralSettingsLocators {
	public WebDriverWait wait;
	public GeneralSettingsLocators(WebDriver driver){
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));	
	}
	@FindBy(name="firstHierarchyLevelCode")
	private WebElement nameFirstDD;
	
	@FindBy(name="secondHierarchyLevelCode")
	private WebElement nameSecondDD;
	
	@FindBy(name="thirdHierarchyLevelCode")
	private WebElement nameThirdDD;
	
	@FindBy(name="userGroupNamingCode")
	private WebElement userGroups;

	@FindBy(id="FormModifiedTextCell")
	private WebElement errormsg;
	
	public WebElement getErrormsg() {
		return errormsg;
	}

	public WebElement getNameFirstDD() {
		return nameFirstDD;
	}

	public WebElement getNameSecondDD() {
		return nameSecondDD;
	}

	public WebElement getNameThirdDD() {
		return nameThirdDD;
	}

	public WebElement getUserGroups() {
		return userGroups;
	}
	
	public String dropDownMessage() {
		String msg=getErrormsg().getText();
		return msg;
	}
	public void DropdownHandling() {
		getNameFirstDD().click();
	}

}
