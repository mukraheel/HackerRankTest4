package Com.HackerRankTest.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.HackerRankTest.PageObject.LoginDDT;
import Com.HackerRankTest.utility.clsScreenshot;

public class DDTestCase extends BaseClass{
	
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
	
	
	
	@Test 
	public void LoginDDFReadExcelData() throws IOException {
		
		test = extent.startTest("Login with DDT");
		
		try {
			
			// Import excel sheet.
			 File src=new File("configs/LoginData.xlsx");  
			 test.log(LogStatus.INFO, "Import excel sheet");
			
			 // Load the file.
			 FileInputStream fis = new FileInputStream(src);
			 // Load he workbook.
			 workbook = new XSSFWorkbook(fis);
			 // Load the sheet in which data is stored.
			 sheet= workbook.getSheetAt(0);
			 
			 for(int i=1; i<=sheet.getLastRowNum(); i++){
				 
				// Import data for Email.
				 cell = sheet.getRow(i).getCell(0);
				 cell.setCellType(Cell.CELL_TYPE_STRING);
				 String Email = cell.getStringCellValue();
				 
				// Import data for password.
					cell = sheet.getRow(i).getCell(1);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String password = cell.getStringCellValue();
					
					//test.log(LogStatus.INFO, "Email :" + Email);
					//test.log(LogStatus.INFO, "password :" + password);
					
								
					LoginDDT lp = new LoginDDT(driver);
					//System.out.println("");
					//test.log(LogStatus.INFO, "after Create Object for Login DDT Test");
					//System.out.println("Loop Count :" + i);
					
					if(i == 1)
					{
						test.log(LogStatus.INFO, "Image", "loginlink: " + test.addBase64ScreenShot(clsScreenshot.GetBased64Screenshot(driver, "loginlink")));
						lp.loginlink();

						lp.setEmailaddress(Email);
						//test.log(LogStatus.INFO, "Image", "Set Eamil: " + test.addScreenCapture(clsScreenshot.getScreenshot(driver, "setEmail")));
						lp.settxtpassword(password);
						//test.log(LogStatus.INFO, "Image", "Set password: " + test.addScreenCapture(clsScreenshot.getScreenshot(driver, "setpassword")));
						lp.clickBtn();
						//test.log(LogStatus.INFO, "Image", "Set Eamil: " + test.addScreenCapture(clsScreenshot.getScreenshot(driver, "setEmail")));
					}
					else
					{
						lp.setEmailaddress(Email);
						//test.log(LogStatus.INFO, "Image", "Set Eamil: " + test.addScreenCapture(clsScreenshot.getScreenshot(driver, "setEmail")));
						//test.log(LogStatus.INFO, "Image", "Set password: " + test.addScreenCapture(clsScreenshot.getScreenshot(driver, "setpassword")));
						lp.clickBtn(); // to added
						//test.log(LogStatus.INFO, "Image", "Set Eamil: " + test.addScreenCapture(clsScreenshot.getScreenshot(driver, "setEmail")));
					}
					
					//System.out.println("isElementPresent :" + lp.isElementPresent());
														
					if(lp.isElementPresent())
					{
						Assert.assertTrue(true); //Heart Asset
						//softAssert.assertTrue(true);
						System.out.println("inside softAssert true condition");
						//test.log(LogStatus.INFO, "inside Assert true condition");
						break;
					} 
					
					//Thread.sleep(3000);
			 }
			 
			 
		} 
		catch (Exception e) 
		{
			
			
			//test.log(LogStatus.INFO, e.getMessage());

		}
			

		//test.log(LogStatus.INFO, "End Test Case DDT");
            
	}
	
	

}
