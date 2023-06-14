package herokuapp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	//Add Remove Elements
	@FindBy(linkText="Add/Remove Elements")
	private WebElement addRemoveElementsLink;
	
	@FindBy(xpath="//button[text()='Add Element']")
	private WebElement addElementBtn;
	
	@FindBy(xpath="//button[text()='Delete']")
	private WebElement removeElementBtn;

	public WebElement getAddRemoveElementsLink() {
		return addRemoveElementsLink;
	}
	public WebElement getAddElementBtn() {
		return addElementBtn;
	}
	public WebElement getRemoveElementBtn() {
		return removeElementBtn;
	}
	
	//Basic Authentication
	@FindBy(linkText="Basic Auth")
	private WebElement basicAuthLink;
	
	@FindBy(xpath="//p")
	private WebElement basicAuthMsg;

	public WebElement getBasicAuthMsg() {
		return basicAuthMsg;
	}
	public WebElement getBasicAuthLink() {
		return basicAuthLink;
	}
	
	// File Upload
	@FindBy(linkText="File Upload")
	private WebElement fileUploadLink;
	
	@FindBy(id="file-upload")
	private WebElement choseFileBtn;
	
	@FindBy(tagName="h3")
	private WebElement fileUploadMsg;
	
	@FindBy(id="file-submit")
	private WebElement uploadBtn;
	
	public WebElement getFileUploadLink() {
		return fileUploadLink;
	}
	public WebElement getChoseFileBtn() {
		return choseFileBtn;
	}
	public WebElement getFileUploadMsg() {
		return fileUploadMsg;
	}
	public WebElement getUploadBtn() {
		return uploadBtn;
	}
	
	
	//Frame
	@FindBy(linkText="Frames")
	private WebElement frames;

	public WebElement getFrames() {
		return frames;
	}
	
	//Single Select dropdown
	@FindBy(linkText="Dropdown")
	private WebElement dropdownLink;

	public WebElement getDropdownLink() {
		return dropdownLink;
	}
	
}
