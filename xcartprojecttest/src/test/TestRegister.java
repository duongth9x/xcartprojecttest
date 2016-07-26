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
import pageobject.RegisterObject;

public class TestRegister {
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {

		OpenBrowser.multi_browser(browser);	

		Common.driver.manage().timeouts().implicitlyWait(Common.TIMEOUTS,TimeUnit.SECONDS);
	}
	
	@Test(priority = 6, enabled = true)
	public void Signup() throws Exception {
		// Get data from Excel
		XSSFSheet ExcelWSheet = ExcelCommon_POI.setExcelFile("1903_TestData.xlsx", "Register");

		String Username = ExcelCommon_POI.getCellData(1, 1, ExcelWSheet);
		String Password = ExcelCommon_POI.getCellData(1, 2, ExcelWSheet);
		String Confirmpassword = ExcelCommon_POI.getCellData(1, 3, ExcelWSheet);

		Common.driver.get(Common.URL);	
		Common.driver.findElement(RegisterObject.linkRegister).click();
		Common.driver.findElement(RegisterObject.txtEmail).clear();
		Common.driver.findElement(RegisterObject.txtEmail).sendKeys(Username);
		Common.driver.findElement(RegisterObject.txtPassword).sendKeys(Password);
		Common.driver.findElement(RegisterObject.txtRepassword).sendKeys(Confirmpassword);
		Common.driver.findElement(RegisterObject.btnSubmit).click();
		Thread.sleep(3000);
		//Verify
		try {
			String ActualMessage = Common.driver.findElement(RegisterObject.actualMess).getText();
			String ExpectMessage = "Log out";
			assertEquals(ActualMessage, ExpectMessage);
			ExcelCommon_POI.writeDataToExcel(1, 4,"1903_TestData.xlsx" , "Register", "Passed");
			System.out.println("Pass");
		}
		catch (Exception e) {
			ExcelCommon_POI.writeDataToExcel(1, 4, "1903_TestData.xlsx", "Register", "Failed");
			System.out.println("Fail");
		} 
	}

	private void assertEquals(String actualMessage, String expectMessage) {
		// TODO Auto-generated method stub
		
	}
	@AfterTest
	public void tearDown() throws Exception {
		//Common.driver.quit();
		//yeuanh
		//miss you <3
	}
}
