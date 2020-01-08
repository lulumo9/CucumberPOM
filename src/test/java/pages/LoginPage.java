package pages;

import org.openqa.selenium.By;
import utilities.BaseClass;

public class LoginPage extends BaseClass {

    public static By userField = By.xpath("//*[@id='userinfo']/form/fieldset/input[1]");
    public static By passwordField = By.xpath("//*[@id='userinfo']/form/fieldset/input[2]");
    static By loginButton = By.id("login-button");

    public void fillingCredentials (String userName, String Password)
    {
        BaseClass.driver.findElement(userField).sendKeys(userName);
        BaseClass.driver.findElement(passwordField).sendKeys(Password);
    }

    public void clickingLoginButton()
    {
        BaseClass.driver.findElement(loginButton).click();
    }
}
