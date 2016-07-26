package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.OpenBrowser;
import common.Common;
import pageobject.BuyingObject;

public class TestBuying {
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		OpenBrowser.multi_browser(browser);	
		//Common.driver.manage().window().maximize();
		Common.driver.manage().timeouts().implicitlyWait(Common.TIMEOUTS,TimeUnit.SECONDS);
	}
	
	@Test
	public void Testbuying1() throws InterruptedException {	
		Common.driver.get(Common.URL);
		Common.driver.findElement(BuyingObject.txtSearch).sendKeys("apple");
		Common.driver.findElement(BuyingObject.txtSearch).sendKeys(Keys.ENTER);
		Common.driver.findElement(BuyingObject.urlName).click();
		Common.driver.findElement(BuyingObject.btnAddtocart).click();
		Common.driver.findElement(BuyingObject.urlYourcart).click();
		//Verify
				
		Common.driver.findElement(BuyingObject.urlEmpty).click();
		Thread.sleep(3000);
		Alert al = Common.driver.switchTo().alert();
		al.accept();
		
	}
	
	@AfterTest
	public void tearDown() throws Exception {
	Common.driver.quit();
	}
}
