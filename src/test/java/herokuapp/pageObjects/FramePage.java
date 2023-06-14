package herokuapp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {

	public FramePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "iFrame")
	private WebElement iframeLink;

	public WebElement getIframeLink() {
		return iframeLink;
	}

	public WebElement getNestedFrameLink() {
		return nestedFrameLink;
	}

	@FindBy(linkText = "Nested Frames")
	private WebElement nestedFrameLink;

	@FindBy(tagName = "h3")
	private WebElement iframeHeaderMsg;

	@FindBy(tagName = "p")
	private WebElement iframeBodyMsg;

	public WebElement getIframeHeaderMsg() {
		return iframeHeaderMsg;
	}

	public WebElement getIframeBodyMsg() {
		return iframeBodyMsg;
	}

	// Nested IFrames

	@FindBy(name = "frame-top")
	private WebElement topIframe;

	@FindBy(name = "frame-bottom")
	private WebElement bottomIframe;

	@FindBy(name = "frame-right")
	private WebElement topRightIframe;

	@FindBy(name = "frame-middle")
	private WebElement topMiddleIframe;

	@FindBy(name = "frame-left")
	private WebElement topLeftIframe;

	public WebElement getTopIframe() {
		return topIframe;
	}

	public WebElement getBottomIframe() {
		return bottomIframe;
	}

	public WebElement getTopRightIframe() {
		return topRightIframe;
	}

	public WebElement getTopMiddleIframe() {
		return topMiddleIframe;
	}

	public WebElement getTopLeftIframe() {
		return topLeftIframe;
	}

}