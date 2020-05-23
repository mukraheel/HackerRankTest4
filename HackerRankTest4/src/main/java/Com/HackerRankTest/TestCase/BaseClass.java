package Com.HackerRankTest.TestCase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Com.HackerRankTest.utility.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
ReadConfig objReadConfig = new ReadConfig();
	
	
	
	public String Url = objReadConfig.geturl();

	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeSuite
	public void testBeforeSuite() {
		System.out.println("BeforeSuite()");
	}
	
	@BeforeTest
	public void setExtent() 
	{
		System.out.println("BeforeTest()");
	}
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		System.out.println("BeforeClass()");
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new   ChromeDriver();
			
		} else if(br.equals("firefoxdriver"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new   FirefoxDriver();
		} else if (br.equals("ie"))
		{
			
			System.setProperty("webdriver.ie.driver",objReadConfig.getIEPath());
			driver = new InternetExplorerDriver();
			
		}
		
		driver.get(Url);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void Setup()
	{
		
		System.out.println("BeforeMethod()");
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		System.out.println("AfterMethod()");
		
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("AfterClass()");
		if(driver!=null)
			driver.close();
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("AfterTest()");
		
	}

	@AfterSuite
	public void testAfterSuite() {
		System.out.println("AfterSuite()");
	}

}
