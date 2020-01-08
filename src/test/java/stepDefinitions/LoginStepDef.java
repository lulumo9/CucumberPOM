package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utilities.BaseClass;

public class LoginStepDef extends BaseClass {

    LoginPage loginP = new LoginPage();

    @Given("user is already on the login page")
    public void user_is_already_on_the_login_page()
    {
        BaseClass.driverInitialization();
    }

    @When("title of the page is Welcome to SportsBet!")
    public void title_of_the_page_is_Welcome_to_SportsBet()
    {
        Assert.assertEquals("SportsBet Login", driver.getTitle());
    }

    @When("enters a valid username and password")
    public void enters_a_valid_username_and_password()
    {
        loginP.fillingCredentials(properties.getProperty("alreadyRegisteredUsername"), properties.getProperty("alreadyRegisteredPassword"));
    }

    @When("click on login button")
    public void click_on_login_button()
    {
        loginP.clickingLoginButton();
    }

    @Then("account page should be displayed")
    public void account_page_should_be_displayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"player-info\"]/form")));
        Assert.assertEquals("SportsBetting Home", driver.getTitle());
    }

    @When("enters and invalid password")
    public void enters_and_invalid_password()
    {
        loginP.fillingCredentials(properties.getProperty("alreadyRegisteredUsername"), properties.getProperty("invalidPassword"));
    }

    @Then("error message is displayed")
    public void error_message_is_displayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='userinfo']/form/fieldset/div")));
        String message = driver.findElement(By.xpath("//*[@id=\'userinfo\']/form/fieldset/div")).getText();
        System.out.println(message);
    }

    @After
    public void closingBrowser()
    {
        driver.quit();
    }
}
