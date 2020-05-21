package Com.HackerRankTest.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Com.HackerRankTest.DataProviderFactory.DataProviderFactory;
import Com.HackerRankTest.PageObject.LoginPage;

public class LoginTest extends BaseClass{
	
	public void updateproFile() throws IOException {

		// create object of faker which was added into POM.xml
		Faker faker = new Faker();

		// to Generate random data for test case process
		String Firstname = faker.name().firstName();
		String Password = faker.name().lastName();
		
		String Emailaddress = Firstname  + "@gmail.com";
		
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
		
		System.out.println("URL is hit");
		
		LoginPage lp = new LoginPage(driver);
		System.out.println("after loginpage object");
		
		lp.loginlink();
		lp.Reglink();
		lp.setEmailaddress(DataProviderFactory.getRandomDataProperty().getValue("Emailaddress"));
		lp.setFirstname(DataProviderFactory.getRandomDataProperty().getValue("Firstname"));
		lp.setPasswoard(DataProviderFactory.getRandomDataProperty().getValue("Password"));
		lp.clickBtn();
		
		System.out.println("Click on Submit Button");
		
		
		if(driver.findElement(By.id("aria-join_neu_email_field-error")).getText().equals("Can't be blank."))
		{
			Assert.assertTrue(true);
			System.out.println("inside Emailaddress condition");
		}
		else if(driver.findElement(By.id("aria-join_neu_password_field-error")).getText().equals("Can't be blank."))
		{
			Assert.assertTrue(true);
			System.out.println("inside Firstname condition");
		}
		
			
	}
	
	
	public void ReadExcelData() throws IOException {
		try {

			String ExcelData = null;

			File src = new File("configs/SalesforceData.xlsx");

			// load file
			FileInputStream fis = new FileInputStream(src);

			// Load workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Load sheet- Here we are loading first sheetonly
			XSSFSheet sh1 = wb.getSheetAt(0);

			// Find number of rows in excel file

			int rowCount = sh1.getLastRowNum() - sh1.getFirstRowNum();
			
			System.out.println("rowsCount :" + rowCount);
			// Create a loop over all the rows of excel file to read it

			for (int i = 1; i < rowCount + 1; i++) {

				Row row = sh1.getRow(i);
				
				// Create a loop to print cell values in a row
				
				if(row==null){
                    sh1.getRow(i+1);
                     continue;
                 }
				
				for (int j = 0; j < row.getLastCellNum(); j++) {
					
					// Print Excel data in console
					ExcelData = row.getCell(j).getStringCellValue();
					

					if (row.getCell(j) != null && (row.getCell(j).toString().equalsIgnoreCase(ExcelData))) {
						sh1.removeRow(row);
						//sh1.shiftRows( 4, sh1.getLastRowNum(), -1);
						
						System.out.println("Data Remove :" + ExcelData);
						// sheet.shiftRows(i, lastIndex, -1);
						
						
					}
				}
				break;
			}
			
			FileOutputStream fileOut = new FileOutputStream(src);
			wb.write(fileOut);
			fileOut.close();

		} catch (

		Exception e) {

			System.out.println(e.getMessage());

		}
	}
	
	

}
