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
    
	@FindBy(xpath="//*[@id=\"join-neu-form\"]/div[1]/div/div[1]/div/button")
	WebElement Reglink;
	
	
	@FindBy(id="join_neu_email_field")
	WebElement txtEmailaddress;
	
	@FindBy(id="join_neu_first_name_field")
	WebElement txtFirstname;
	
	@FindBy(id="join_neu_password_field")
	WebElement txtPassword ;
	
	@FindBy(name="submit_attempt")
	WebElement btnLogin;
	
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
		driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button")).click();;
	}
	
	public void Reglink()
	{
		
		Reglink.click();
	}

}
