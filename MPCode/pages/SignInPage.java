package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	WebDriver driver = null;
	public SignInPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//p[text()='Please enter your email address to create an account.']")
	private WebElement createAccountText;  
	
	public WebElement getCreateAccountText()
	{
		return createAccountText;
	}

}
