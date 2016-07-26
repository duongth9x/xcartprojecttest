package test;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.ExcelCommon_POI;
import common.OpenBrowser;
import common.Common;
import pageobject.LoginObject;
import pageobject.RegisterObject;

public class TestLogin {

	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		
		OpenBrowser.multi_browser(browser);	

		Common.driver.manage().timeouts().implicitlyWait(Common.TIMEOUTS,TimeUnit.SECONDS);
	}
	
	@Test(priority = 6, enabled = true)
	public void Login_Successful() throws Exception {
		// Get data from Excel
				XSSFSheet ExcelWSheet = ExcelCommon_POI.setExcelFile("1903_TestData.xlsx", "Login");
				
				String Username = ExcelCommon_POI.getCellData(1, 1, ExcelWSheet);
				String Password = ExcelCommon_POI.getCellData(1, 2, ExcelWSheet);
		Common.driver.get(Common.URL);	
		Common.driver.findElement(LoginObject.linkLogin).click();
		Common.driver.findElement(LoginObject.txtEmail).sendKeys(Username);
		Common.driver.findElement(LoginObject.txtPass).sendKeys(Password);
		Common.driver.findElement(LoginObject.btnSignin).click();
		Thread.sleep(5000);
		//verify
		try {
			String ActualMessage = Common.driver.findElement(RegisterObject.actualMess).getText();
			String ExpectMessage = "Log out";
			assertEquals(ActualMessage, ExpectMessage);
			ExcelCommon_POI.writeDataToExcel(1, 3,"1903_TestData.xlsx" , "Login", "Passed");
			System.out.println("Pass");
		}
		catch (Exception e) {
			ExcelCommon_POI.writeDataToExcel(1, 3, "1903_TestData.xlsx", "Login", "Failed");
			System.out.println("Fail");
		} 
		
		
		
		//logout
		Common.driver.findElement(LoginObject.linkLogout).click();
		Thread.sleep(10000);
	}
	
	
	private void assertEquals(String actualMessage, String expectMessage) {
		// TODO Auto-generated method stub
		
	}

	@AfterTest
	public void tearDown() throws Exception {
	Common.driver.quit();
	}


}
