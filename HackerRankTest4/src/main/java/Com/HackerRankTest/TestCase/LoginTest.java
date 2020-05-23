package Com.HackerRankTest.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import Com.HackerRankTest.DataProviderFactory.DataProviderFactory;
import Com.HackerRankTest.PageObject.LoginDDT;
import Com.HackerRankTest.PageObject.LoginPage;

import Com.HackerRankTest.utility.Excel;

import org.apache.poi.ss.usermodel.Cell;



public class LoginTest extends BaseClass {
	
	  
	    SoftAssert softAssert = new SoftAssert();
	
	public void updateproFile() throws IOException {

		// create object of faker which was added into POM.xml
		Faker faker = new Faker();

		// to Generate random data for test case process
		String Firstname = faker.name().firstName() + faker.name().lastName();
		String Password = faker.name().lastName() + Firstname;
		
		String Emailaddress = Firstname  + "@gmail.com";
		
		System.out.print("Account created data :" + Firstname + " " +  Password + " " + Emailaddress);
		
		// create object for read and write RandomData properties file as input and output stream
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;
        
        // create object of properties class for set key and value into the properties file 
            Properties configProperty = new Properties();
  
            // load RandomData properties for update and create key values
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
		System.out.println("inside loginTest");
		
		// call method for generate random  data 
		updateproFile();
		
		System.out.println("URL hit for Case 1");
		
		LoginPage lp = new LoginPage(driver);
		System.out.println("after loginpage object");
		
		lp.loginlink();
		lp.Reglink();
		lp.setEmailaddress(DataProviderFactory.getRandomDataProperty().getValue("Emailaddress"));
		lp.setFirstname(DataProviderFactory.getRandomDataProperty().getValue("Firstname"));
		lp.setPasswoard(DataProviderFactory.getRandomDataProperty().getValue("Password"));
		lp.clickBtn();
		lp.Logout();
		
		System.out.println("Case 1 End");
			
	}
	
	
	
	
	
	
	
}
