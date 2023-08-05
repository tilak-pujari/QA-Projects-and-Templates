package nocommerce.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC4_NC_RegisterTest {
	

	WebDriver driver;
	@Test(priority=1)
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test(priority=2)
	public void registerNew() {
		
		WebElement register=driver.findElement(By.linkText("Register"));
		register.click();
		
		String registermsg="Register";
		String actregmsg=driver.findElement(By.xpath("//h1[text()='Register']")).getText();
		Assert.assertEquals(registermsg,actregmsg);
		Reporter.log("Register Page is Loaded",true);		
	}
	
	@Test(priority=3)
	public void addDetailsRegister() {
		
		String fname="Amar",lname="Roy",emailId="amarroy12@gmail.com";
		String dobDay="10",dobMonth="8",dobYear="2000";
		String comname="rajaramxyz ltd.";
		String pwd="hello123";
		//Your Personal Details
		WebElement male=driver.findElement(By.id("gender-male"));
		WebElement female=driver.findElement(By.id("gender-female"));
		WebElement firstName=driver.findElement(By.id("FirstName"));
		WebElement lastName=driver.findElement(By.id("LastName"));
		WebElement email=driver.findElement(By.id("Email"));
		
		male.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		email.sendKeys(emailId);
		
		WebElement day=driver.findElement(By.name("DateOfBirthDay"));
		WebElement month=driver.findElement(By.name("DateOfBirthMonth"));
		WebElement year=driver.findElement(By.name("DateOfBirthYear"));
		Select s=new Select(day);
		s.selectByValue(dobDay);
	
		Select s1=new Select(month);
		s1.selectByValue(dobMonth);
		
		Select s2=new Select(year);
		s2.selectByValue(dobYear);
		
		
		//
		WebElement companyName=driver.findElement(By.id("Company"));
		companyName.sendKeys(comname);
		
		WebElement newsletter=driver.findElement(By.id("Newsletter"));
		newsletter.click();
		
		WebElement password=driver.findElement(By.id("Password"));
		WebElement confirmPwd=driver.findElement(By.id("ConfirmPassword"));
		password.sendKeys(pwd);
		confirmPwd.sendKeys(pwd);
		
		WebElement confirmregister=driver.findElement(By.id("register-button"));
		confirmregister.click();
		String registrationmsg="Your registration completed";
		WebElement confirmmsg=driver.findElement(By.className("result"));
		
		Assert.assertEquals(registrationmsg, confirmmsg.getText());
		Reporter.log("Registration of New Customer is Successful",true);
		
	}

}
