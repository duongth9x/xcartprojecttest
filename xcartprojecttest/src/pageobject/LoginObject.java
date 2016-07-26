package pageobject;

import org.openqa.selenium.By;

public class LoginObject {
	public static By linkLogin = By.linkText("Sign in");
    public static By txtEmail = By.xpath(".//*[@id='login-email']");
    public static By txtPass = By.xpath(".//*[@id='login-password']");
    public static By btnSignin = By.cssSelector("button.btn:nth-child(1)");
    public static By actualMess = By.linkText("Log out");
    public static By linkForget = By.linkText("Forgot password?");
    public static By linkLogout = By.linkText("Log out");
  
}
