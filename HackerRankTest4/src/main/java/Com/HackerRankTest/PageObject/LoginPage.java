package Com.HackerRankTest.PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "button.select-signin")
	WebElement signinlink;
    
	@FindBy(css = "button.select-register")
	WebElement Reglink;
		
	@FindBy(id="join_neu_email_field")
	WebElement txtEmailaddress;
	
	@FindBy(id="join_neu_first_name_field")
	WebElement txtFirstname;
	
	@FindBy(id="join_neu_password_field")
	WebElement txtPassword ;
	
	@FindBy(name="submit_attempt")
	WebElement btnLogin;
	
	@FindBy(css ="a[aria-label='Your account']")
	WebElement profilelink;
	
	@FindBy(linkText ="Sign out")
	WebElement Signoutlink;
		
	public void setEmailaddress(String username)
	{
		txtEmailaddress.sendKeys(username);
	}
	
	public void setFirstname(String username)
	{
		txtFirstname.sendKeys(username);
	}
	
	public void setPasswoard(String userPass)
	{
		txtPassword.sendKeys(userPass);
	}
	
	public void clickBtn()
	{
		btnLogin.click();
	}
	
	public void loginlink()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		signinlink.click();;
	}
	
	public void Reglink()
	{
		
		Reglink.click();
	}
	
	public void Logout()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementPresent(By.cssSelector("a[aria-label='Your account']")))
		{
			profilelink.click();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementPresent(By.linkText("Sign out")))
		{
			Signoutlink.click();
		}
	}
	
	public boolean isElementPresent(By by) {
		  try {
		    driver.findElement(by);
		    return true;
		  }
		catch (org.openqa.selenium.NoSuchElementException e) {
		    return false;
		  }
		}
	
public boolean isElementDisplayed(WebElement element) {
        
		boolean isPresent = false;
       
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
        //search for elements and check if list is empty
        if (driver.findElement(By.cssSelector("div[class='has-error-msg mt-xs-1 text-red is-visible']")).isDisplayed()) {
            isPresent = true;
        }
        //rise back implicitly wait time
        
        return isPresent;
    }
}
