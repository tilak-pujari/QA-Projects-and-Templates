package selenium.elementRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TypeOfWorkLocators {
	public WebDriverWait wait;
	public TypeOfWorkLocators(WebDriver driver){
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));		
	}

	@FindBy(xpath="//div[contains(@id,'ext-gen')]/div[1]")
	private WebElement createTypeWork;
	
	@FindBy(id="name")
	private WebElement towName;
	
	@FindBy(name="active")
	private WebElement towStatus;
	
	@FindBy(css="[type='submit']")
	private WebElement CreateTypeOfWork;
	
	@FindBy(xpath="//td[@id='ButtonPane']/input[2]")
	private WebElement cancel;

	public WebElement getCreateTypeWork() {
		return createTypeWork;
	}

	public WebElement getTowName() {
		return towName;
	}

	public WebElement getTowStatus() {
		return towStatus;
	}

	public WebElement getCreateTypeOfWork() {
		return CreateTypeOfWork;
	}

	public WebElement getCancel() {
		return cancel;
	}
	
	public void alertPopUp(String name) {
	
		getCreateTypeWork().click();
		getTowName().sendKeys(name);
		getCancel().click();
		
	}
}
