package pageobject;

import org.openqa.selenium.By;

public class RegisterObject {
	public static By linkRegister = By.linkText("Register");
    public static By txtEmail = By.xpath(".//*[@id='login']");
    public static By txtPassword = By.xpath(".//*[@id='password']");
    public static By txtRepassword = By.xpath(".//*[@id='password-conf']");
    public static By btnSubmit = By.xpath("//div[2]/div[2]/div[1]/button");
    public static By actualMess = By.linkText("Log out");
    public static By linkLogout = By.linkText("Log out");
}
