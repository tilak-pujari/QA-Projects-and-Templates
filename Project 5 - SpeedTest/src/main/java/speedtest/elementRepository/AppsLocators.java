package speedtest.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppsLocators {
	public AppsLocators(WebDriver driver){
		PageFactory.initElements(driver,this);	
	}
	
	public WebElement getMobileApps() {
		return mobileApps;
	}

	public WebElement getDownAppAndroid() {
		return downAppAndroid;
	}

	public WebElement getDownAppiOS() {
		return downAppiOS;
	}

	public WebElement getDeskTopApps() {
		return deskTopApps;
	}

	public WebElement getDownAppWindows() {
		return downAppWindows;
	}

	public WebElement getDownAppMacOS() {
		return downAppMacOS;
	}

	public WebElement getBrowserExt() {
		return browserExt;
	}

	public WebElement getChromeBrowserExt() {
		return chromeBrowserExt;
	}

	public WebElement getTvApp() {
		return tvApp;
	}

	public WebElement getSpeedTestForAppleTV() {
		return speedTestForAppleTV;
	}

	public WebElement getCLI() {
		return CLI;
	}

	public WebElement getSpeedTestForCLI() {
		return speedTestForCLI;
	}

	@FindBy(linkText="Mobile apps")
	private WebElement mobileApps;
	
	@FindBy(linkText="Speedtest for Android")
	private WebElement downAppAndroid;
	
	@FindBy(linkText="Speedtest for iOS")
	private WebElement downAppiOS;
	
	
	@FindBy(linkText="Desktop apps")
	private WebElement deskTopApps;
	
	@FindBy(linkText="Speedtest for Windows")
	private WebElement downAppWindows;
	
	@FindBy(linkText="Speedtest for macOS")
	private WebElement downAppMacOS;
	
	
	@FindBy(linkText="Browser extension")
	private WebElement browserExt;
	
	@FindBy(linkText="Speedtest for Chrome")
	private WebElement chromeBrowserExt;
	
	
	@FindBy(linkText="TV app")
	private WebElement tvApp;
	
	@FindBy(linkText="Speedtest for Apple TV")
	private WebElement speedTestForAppleTV;
	
	
	
	@FindBy(linkText="Command line interface app")
	private WebElement CLI;
	
	@FindBy(linkText="Speedtest CLI")
	private WebElement speedTestForCLI;
	
	}