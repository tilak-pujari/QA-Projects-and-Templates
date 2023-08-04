package selenium.elementRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeLocators {
	public WebDriverWait wait;
	public HomeLocators(WebDriver driver){
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));	
	}

	@FindBy(id="container_tasks")
	private WebElement tasksIcon;
	
	@FindBy(className="popup_menu_button_settings")
	private WebElement settingsIcon;
	
	@FindBy(linkText="Types of Work")
	private WebElement typeOfWork;
	
	@FindBy(xpath="//a/div[contains(text(),'General Settings')]")
	private WebElement generalSettings;
	
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	public WebElement getGeneralSettings() {
		return generalSettings;
	}
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getTasksIcon() {
		return tasksIcon;
	}
	public WebElement getSettingsIcon() {
		return settingsIcon;
	}
	public WebElement getTypeOfWork() {
		return typeOfWork;
	}
	public void clickTasks() {
		getTasksIcon().click();
	}
	public void clicktSettings() {
		getSettingsIcon().click();
	}
	public void clickTypeOfWork() {
		getTypeOfWork().click();
	}
	public void clickGeneralSettings() {
		getGeneralSettings().click();
	}
	public void clickLogout() {
		getLogout().click();
	}
}
