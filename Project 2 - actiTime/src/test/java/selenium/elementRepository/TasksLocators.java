package selenium.elementRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TasksLocators {
	public WebDriverWait wait;
	public TasksLocators(WebDriver driver){
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//table[@class='headerRowTable']/tbody[1]/tr[1]/td[1]/div[1]")
	private WebElement taskCB;
	
	@FindBy(css=".delete.button")
	private WebElement taskDelete;
	
	@FindBy(xpath="//div[contains(text(),'You are about to delete')]")
	private WebElement taskDeleteMsg;
	
	public WebElement getTaskCB() {
		return taskCB;
	}

	public WebElement getTaskDelete() {
		return taskDelete;
	}

	public WebElement getTaskDeleteMsg() {
		return taskDeleteMsg;
	}
	
	public void hiddenDivisonMessage() {
		 getTaskCB().click();
		 
		 wait.until(ExpectedConditions.elementToBeClickable(getTaskDelete()));
		 getTaskDelete().click();
		 wait.until(ExpectedConditions.elementToBeClickable(getTaskDeleteMsg()));
		 String msg=getTaskDeleteMsg().getText();
		 System.out.println(msg);
	}
	//Customer Creation
	
	@FindBy(css=".title.ellipsis")
	private WebElement tasksAddNew;
	
	@FindBy(className="createNewCustomer")
	private WebElement tasksNewCustomer;
	
	@FindBy(className="inputNameField")
	private WebElement nameField;

	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement descriptionField;
	
	@FindBy(xpath="//div[text()='Create Customer']")
	private WebElement createCustomerBtn;
	
	@FindBy(css=".titleEditButtonContainer>.title")
	private WebElement customerCreationMsg;

	public WebElement getTasksAddNew() {
		return tasksAddNew;
	}

	public WebElement getTasksNewCustomer() {
		return tasksNewCustomer;
	}

	public WebElement getNameField() {
		return nameField;
	}

	public WebElement getDescriptionField() {
		return descriptionField;
	}

	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}
	public WebElement getCustomerCreationMsg() {
		return customerCreationMsg;
	}
	public String createCustomer(String name,String description) {
		getTasksAddNew().click();
		getTasksNewCustomer().click();
		getNameField().sendKeys(name);
		getDescriptionField().sendKeys(description);
		getCreateCustomerBtn().click();
		wait.until(ExpectedConditions.textToBePresentInElementValue(getCustomerCreationMsg(),name));
		String cmsg=getCustomerCreationMsg().getText();
		return cmsg;	
	}
}
