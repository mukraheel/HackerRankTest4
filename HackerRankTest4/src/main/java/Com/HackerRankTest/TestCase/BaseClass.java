package Com.HackerRankTest.TestCase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.HackerRankTest.utility.ReadConfig;
import Com.HackerRankTest.utility.clsScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass {
	
	ReadConfig objReadConfig = new ReadConfig();
	public String Url = objReadConfig.geturl();

	clsScreenshot objclsScreenshot = new clsScreenshot();
	
	public static WebDriver driver;
	public static Logger logger;
	
    public static ExtentReports extent;
    public static ExtentTest test;
	
	
	@BeforeSuite
	public void testBeforeSuite() {
		System.out.println("BeforeSuite()");
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		//extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/myReport" + dateName +  ".html",true);
		extent = new ExtentReports("D:\\AutomationReport\\" + "myReport" + dateName +  ".html",true);
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
			 
	}
	
	@BeforeMethod
	public void Setup()
	{
		
		System.out.println("BeforeMethod()");
		
	}
	
	@BeforeTest
	public void setExtent() 
	{
		System.out.println("BeforeTest()");
		
	}
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br )
	{
		System.out.println("BeforeClass()");
		//test = extent.startTest("ExtentDemo");
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
	
	
	
	
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("AfterClass()");
		if(driver!=null)
		{
			System.out.println("Before driver.close");
			driver.close();
			System.out.println("After driver.close");
			
		}
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		System.out.println("AfterMethod()");
		
		if (result.getStatus() == ITestResult.FAILURE) {
				test.log(LogStatus.FAIL, "FAILDCASE", result.getName()+" Test case FAILED due to below issues:");
	            test.log(LogStatus.FAIL, result.getThrowable());
	            //test.log(LogStatus.FAIL,test.addScreenCapture(clsScreenshot.getScreenshot(driver, result.getName())+ "Test Failed"));
            
			  } 
		else if (result.getStatus() == ITestResult.SKIP) {
				test.log(LogStatus.SKIP, "SKIPCASE", result.getName()+" Test case FAILED due to below issues:");
	            test.log(LogStatus.SKIP, result.getThrowable());
              }
		else if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(LogStatus.PASS, "SUCCESSCASE", result.getName()+" Test case PASS:");
				//test.log(LogStatus.PASS,test.addScreenCapture(clsScreenshot.getScreenshot(driver, result.getName())+ "Test SUCCESS"));
			  }
		
	}
	
	@AfterTest
	public void endReport()
	{
		System.out.println("AfterTest()");
		
	}

	@AfterSuite
	public void testAfterSuite() {
		System.out.println("AfterSuite()");
		extent.flush();
	}
	
	

}
