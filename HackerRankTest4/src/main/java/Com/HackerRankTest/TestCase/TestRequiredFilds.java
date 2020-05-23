package Com.HackerRankTest.TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.HackerRankTest.DataProviderFactory.DataProviderFactory;
import Com.HackerRankTest.PageObject.LoginPage;

public class TestRequiredFilds extends BaseClass {
	
	@Test
	public void RequiredFilds()
	{

		System.out.println("URL hit for RequiredFilds");
		
		LoginPage lp = new LoginPage(driver);
		System.out.println("after loginpage object for TestRequiredFilds");
		
		lp.loginlink();
		lp.Reglink();
		lp.setEmailaddress("");
		lp.setFirstname(DataProviderFactory.getRandomDataProperty().getValue("Firstname"));
		lp.setPasswoard(DataProviderFactory.getRandomDataProperty().getValue("Password"));
		lp.clickBtn();
		
		System.out.println("Click on Submit Button");
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver.findElement(By.cssSelector("div[class='has-error-msg mt-xs-1 text-red is-visible']")).getText().equals("Can't be blank."))
		{
			//System.out.println("Error value :" + driver.findElement(By.cssSelector("div[id=aria-join_neu_email_field-error]")).getText());
			Assert.assertTrue(true);
			System.out.println("inside Emailaddress condition");
		}
		else if(driver.findElement(By.id("aria-join_neu_password_field-error")).getText().equals("Can't be blank."))
		{
			Assert.assertTrue(true);
			System.out.println("inside Firstname condition");
		}
		
		System.out.println("RequiredFilds Case 2 End");
	}

}
