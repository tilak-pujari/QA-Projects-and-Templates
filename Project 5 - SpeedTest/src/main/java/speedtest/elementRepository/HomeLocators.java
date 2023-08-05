package speedtest.elementRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeLocators {
	
	public HomeLocators(WebDriver driver){
	PageFactory.initElements( driver,this);
	}
	
	@FindBys({@FindBy(xpath="//ul[@class='nav-menu']/li/a")})
	private List<WebElement> navmenu;
	
	@FindBy(className="svg-icon-speedtest-logo")
	private WebElement homeLogo;
	
	
	@FindBy(xpath="//a[text()='Apps']")
	private WebElement apps;
	
	
	public WebElement getApps() {
		return apps;
	}
	public void clickApps() {
		getApps().click();
	}
	
	@FindBy(linkText="Analysis")
	private WebElement analysis;
	
	public WebElement getAnalysis() {
		return analysis;
	}
	public WebElement getNetwork() {
		return network;
	}
	public WebElement getDevelopers() {
		return developers;
	}
	public WebElement getEnterprise() {
		return enterprise;
	}
	public WebElement getAbout() {
		return about;
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getHiddenCloseBtn() {
		return hiddenCloseBtn;
	}

	@FindBy(linkText="Network")
	private WebElement network;
	
	@FindBy(linkText="Developers")
	private WebElement developers;
	
	@FindBy(linkText="Enterprise")
	private WebElement enterprise;
	
	@FindBy(linkText="About")
	private WebElement about;
	
	@FindBy(xpath="//ul[@class='nav-menu']/li[7]/a[1]")
	private WebElement login;
	
	
	
	@FindBy(id="onetrust-close-btn-container")
	private WebElement hiddenCloseBtn;
	
	@FindBy(className="start-text")
	private WebElement startRun;

	@FindBy(xpath="//div[text()='Result ID']")
	private WebElement resultwait;
	
	@FindBy(className="result-area-test")
	private WebElement result;
	
	
	
	public List<WebElement> getNavmenu() {
		return navmenu;
	}
	public WebElement getHomeLogo() {
		return homeLogo;
	}
	
	public void waitAMinute(WebDriver driver,WebElement wb,String text) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(wb,text));
	}
	public WebElement getStartRun() {
		return startRun;
	}
	public WebElement getResultwait() {
		return resultwait;
	}
	public WebElement getResult() {
		return result;
	}
	
	
}