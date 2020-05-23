package Com.HackerRankTest.TestCase;

import org.testng.annotations.Test;
import Com.HackerRankTest.PageObject.CaseAddProduct;

public class TestCaseAddProduct extends BaseClass {
	
	@Test
	public void CaseAddProduct() throws InterruptedException
	{
		System.out.println("URL hit for CaseAddProduct");
		
		CaseAddProduct objpro = new CaseAddProduct(driver);
		System.out.println("after CaseAddProduct object for CaseAddProduct");
		
		objpro.Clickonproduct();
		objpro.switchwindow();
		objpro.ProductTitle();
		objpro.Selectoption();
		objpro.personalisation();
		objpro.Addtocart();
		objpro.productMatch();
				
		System.out.println("CaseAddProduct Case end");

	}
}