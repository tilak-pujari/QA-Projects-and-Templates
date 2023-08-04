package op.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationLocators {
	
	public RegistrationLocators(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy()
	private WebElement firstName;

}
