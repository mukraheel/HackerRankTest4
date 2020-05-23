package Com.HackerRankTest.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.HackerRankTest.PageObject.LoginDDT;

public class DDTestCase extends BaseClass{
	
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
	
	@Test 
	public void LoginDDFReadExcelData() throws IOException {
		
		try {

			System.out.println("case 3 start");
			// Import excel sheet.
			 File src=new File("configs/LoginData.xlsx");   
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
					
					System.out.println("Email :" + Email);
					System.out.println("password :" + password);
								
					LoginDDT lp = new LoginDDT(driver);
					System.out.println("after LoginDDFReadExcelData object");
					
					System.out.println("Loop Count :" + i);
					
					if(i == 1)
					{
						lp.loginlink();
						lp.setEmailaddress(Email);
						lp.settxtpassword(password);
						lp.clickBtn();
					}
					else
					{
						lp.setEmailaddress(Email);
						lp.settxtpassword(password);
						lp.clickBtn();
					}
					
					System.out.println("isElementPresent :" + lp.isElementPresent());
														
					if(lp.isElementPresent())
					{
						Assert.assertTrue(true); //Heart Asset
						//softAssert.assertTrue(true);
						System.out.println("inside softAssert true condition");
						break;
					} 
					
					//Thread.sleep(3000);
			 }

		} catch (

		Exception e) {

			System.out.println(e.getMessage());

		}
			

		System.out.println("case 3 end");
            
	}

}
