package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver = null;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//a[@class='login']")
	private WebElement SignInButton;  
	
	public WebElement getSignInButton()
	{
		return SignInButton;
	}
	
	@FindBy(xpath="//a[text()='Contact us']")
	private WebElement contactUsButton;  
	
	public WebElement getContactUsButton()
	{
		return contactUsButton;
	}
	    
	
	
}
