package Com.HackerRankTest.PageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CaseAddProduct {
	
	WebDriver driver;
	static String ProductTitle = "";
	ArrayList<String> tabs2;
	
	public CaseAddProduct(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	
	public void Clickonproduct()
	{
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("li[data-palette-listing-id='675830714']")).click();
	}
	
	public void switchwindow()
	{
		tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}
	
	public void ProductTitle()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ProductTitle = driver.findElement(By.cssSelector("h1[data-listing-id='675830714']")).getText();
		
		System.out.println("ProductTitle :" + ProductTitle);
	}
	
	public void Selectoption()
	{
		 Select select = new Select(driver.findElement(By.cssSelector("select[id='inventory-variation-select-0']")));
		  List<WebElement> allOptions = select.getOptions();
		  
		  for(int i=0; i<allOptions.size(); i++) 
		  {
		  		if(allOptions.get(i).getText().trim().equals("Two children")) 
		  			{
		  				System.out.println("value match :" + allOptions.get(i).getText().trim());
		  				select.selectByVisibleText(allOptions.get(i).getText().trim()); 
		  				break; 
		  			} 
		  }
		
		
	}
	
	public void personalisation()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(
		ExpectedConditions.elementToBeClickable(By.cssSelector("textarea[id=personalization-input]")));
		element.sendKeys("Test product");
	
	}
	
	public void Addtocart()
	{
		
		driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--filled wt-width-full']")).click();
	}
	
	public void productMatch()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='display-block pb-xs-1']")));
		
		Assert.assertEquals(element.getText(), ProductTitle);
		System.out.println("Product verify into the cart");
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		
	}
}
