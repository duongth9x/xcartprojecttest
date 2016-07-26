package pageobject;

import org.openqa.selenium.By;

public class BuyingObject {
	public static By txtSearch = By.xpath(".//*[@id='substring-default']");
	public static By urlName = By.xpath(".//*[@id='content']/div/div/div[2]/div[2]/div/div/div[6]/ul/li[1]/div/div[4]/a");
	public static By btnAddtocart = By.cssSelector(".btn.regular-button.regular-main-button.add2cart.submit");
	public static By urlYourcart = By.linkText("your cart");
	public static By urlEmpty = By.linkText("Empty your cart");
	public static final String expectedMess = "Subtotal";
    public static By actualMess = By.xpath(".//*[@id='shopping-cart']/ul/li/strong");
}
