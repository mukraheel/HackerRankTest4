package Com.HackerRankTest.PageObject;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		
		txtEmailaddress.clear();
		txtEmailaddress.sendKeys(username);
	}
	
	public void settxtpassword(String password)
	{
		txtpassword.clear();
		txtpassword.sendKeys(password);
	}
	
	public void clickBtn()
	{
		btnLogin.click();
	}
	
	public void loginlink()
	{
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button")).click();;
		
		/*
		List<WebElement> options = driver.findElements(By.cssSelector("div.wt-flex-shrink-xs-0>nav>ul>li"));
		for(WebElement options1 : options)
		{
			if(options1.getText().equalsIgnoreCase("Sign in"))
			{
				options1.click();
			}
		}*/
	}
	
		
	
	 public boolean isElementPresent() {
	        boolean isPresent = true;
	        
	        //search for elements and check if list is empty
	        if (driver.findElements(By.cssSelector("a[aria-label='Your account']")).isEmpty()) {
	            isPresent = false;
	        }
	        //rise back implicitly wait time
	        
	        return isPresent;
	    }
	
	
	

}
