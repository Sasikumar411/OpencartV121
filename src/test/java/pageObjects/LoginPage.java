package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassowrd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnlogin;
	
	//Action methods
	
	public void setEmailAddress(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassowrd.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnlogin.click();
	}
	

	
	
	
	

}
