package Com.HackerRankTest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDDT {
	
	WebDriver driver;
	
	public LoginDDT(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
    
	@FindBy(xpath="//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button")
	WebElement loginlink;
	
	
	@FindBy(id="join_neu_email_field")
	WebElement txtEmailaddress;
	
	@FindBy(id="join_neu_password_field")
	WebElement txtpassword;
	
	@FindBy(name="submit_attempt")
	WebElement btnLogin;
	
	public void setEmailaddress(String username)
	{
		txtEmailaddress.sendKeys(username);
	}
	
	public void settxtpassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	
	public void clickBtn()
	{
		btnLogin.click();
	}
	
	public void loginlink()
	{
		loginlink.click();
	}
	

}
