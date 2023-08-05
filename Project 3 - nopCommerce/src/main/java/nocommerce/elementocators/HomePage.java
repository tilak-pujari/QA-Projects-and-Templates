package nocommerce.elementocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="header-logo")
	private WebElement homelogo;
	
	@FindBy(linkText = "Register")
	private WebElement registerBtn;
	
	@FindBy(className="ico-login")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//span[text()='Wishlist']")
	private WebElement wishListBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getWishListBtn() {
		return wishListBtn;
	}

	public WebElement getHomelogo() {
		return homelogo;
	}

}
