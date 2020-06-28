package Com.HackerRankTest.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.HackerRankTest.DataProviderFactory.DataProviderFactory;
import Com.HackerRankTest.PageObject.LoginDDT;
import Com.HackerRankTest.PageObject.LoginPage;

import Com.HackerRankTest.utility.Excel;
import Com.HackerRankTest.utility.clsScreenshot;

import org.apache.poi.ss.usermodel.Cell;



public class LoginTest extends BaseClass {
	
	
	
	public void updateproFile() throws IOException {

		
		Faker faker = new Faker();

		String Firstname = faker.name().firstName() + faker.name().lastName();
		String Password = faker.name().lastName() + Firstname;
		
		String Emailaddress = Firstname  + "@gmail.com";
		
		System.out.println("Account created data :" + Firstname + " " +  Password + " " + Emailaddress);
		
		
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;
        
       
            Properties configProperty = new Properties();
              
            File file = new File("./configs/RandomData2.properties");
            fileIn = new FileInputStream(file);
            configProperty.load(fileIn);
            configProperty.setProperty("Firstname", Firstname);
    		configProperty.setProperty("Password", Password);
    		configProperty.setProperty("Emailaddress", Emailaddress);
    		
            fileOut = new FileOutputStream(file);
            configProperty.store(fileOut, null);
            fileIn.close();
           

	}
	
	
	@Test 
	public void CreateAccountTest() throws IOException
	{
		
		test = extent.startTest("Create Account Test");
		
		
		
		
		try
		{
		test.log(LogStatus.INFO, "This step shows usage of Create Account Test");
		// call method for generate random  data 
		updateproFile();
		test.log(LogStatus.INFO , "Called method for dynamic data");
		
		
		LoginPage lp = new LoginPage(driver);
		test.log(LogStatus.INFO , "after loginpage object");
		test.log(LogStatus.INFO,  "Homepage: " + test.addBase64ScreenShot(clsScreenshot.GetBased64Screenshot(driver, "Homepage"))); // adding screen shot
		lp.loginlink();
		test.log(LogStatus.INFO,  "loginlink: " + test.addBase64ScreenShot(clsScreenshot.GetBased64Screenshot(driver, "loginlink"))); // adding screen shot
		test.log(LogStatus.INFO , "Click Login Link");
		
		lp.Reglink();
		//test.log(LogStatus.INFO, "Image", "Reglink: " + test.addScreenCapture(clsScreenshot.getScreenshot(driver, "Reglink"))); // adding screen shot
		//test.log(LogStatus.INFO , "Click on Registration Link");

		lp.setEmailaddress(DataProviderFactory.getRandomDataProperty().getValue("Emailaddress"));
		lp.setFirstname(DataProviderFactory.getRandomDataProperty().getValue("Firstname"));
		lp.setPasswoard(DataProviderFactory.getRandomDataProperty().getValue("Password"));
		//test.log(LogStatus.INFO, "Image", "Set Values: " + test.addScreenCapture(clsScreenshot.getScreenshot(driver, "RegValues"))); // adding screen shot
		//test.log(LogStatus.INFO , "set values for Registration");
		
		lp.clickBtn();
		//test.log(LogStatus.INFO, "Image", "clickBtn: " + test.addScreenCapture(clsScreenshot.getScreenshot(driver, "clickBtn"))); // adding screen shot
		//test.log(LogStatus.INFO , "Click on Sumbit button");
		lp.Logout();
		//test.log(LogStatus.INFO, "Image", "Logout: " + test.addScreenCapture(clsScreenshot.getScreenshot(driver, "Logout"))); // adding screen shot
		//test.log(LogStatus.INFO , "Click on Logout button");
		
		//test.log(Status.INFO , "End Test Create Account Test ");
		
		
				
		}
		catch (Exception e) 
		{
			//test.log(LogStatus.FAIL, "TEST CASE FAILED IS " + e.getMessage());
		}
		
		
	}
	
	
}
