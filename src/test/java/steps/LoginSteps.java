package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.ConfigFileReader;
import utils.WebDriverUtils;

public class LoginSteps extends WebDriverUtils {
    @Given("Login Page is loaded")
    public void login_page_is_loaded() {
        launchBrowser(ConfigFileReader.getPropertyV("url"));
    }

    @When("user Enters valid UserName")
    public void user_enters_valid_user_name() {
        String userName = ConfigFileReader.getPropertyV("userName");
        //webDriver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
        loginPage.userNameTextBox.sendKeys(userName);
    }

    @When("User Enters valid Password")
    public void user_enters_valid_password() {
        String password = ConfigFileReader.getPropertyV("password");
        //webDriver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
        loginPage.passwordTextBox.sendKeys(password);
    }

    @When("User clicks on the login Button")
    public void user_clicks_on_the_login_button() {
       // webDriver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        loginPage.loginBtn.click();
    }

    @Then("verify User is logged in")
    public void verify_user_is_logged_in() {

        boolean isDisplayed = webDriver.findElement(By.xpath("//b[normalize-space()='Dashboard']")).isDisplayed();
        Assert.assertTrue(isDisplayed);
        closeWebDriver();

    }

    @When("user Enters invalid UserName")
    public void userEntersInvalidUserName() {
        //String userName = ConfigFileReader.getPropertyV("userName");
        //webDriver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("");
        loginPage.userNameTextBox.sendKeys("");
    }

    @Then("verify User Gets the error msg")
    public void verifyUserGetsErrorMessage() {
        //String actual = webDriver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
        String actual =loginPage.loginErrorMsg.getText();
        String expected = "Username cannot be empty";
        Assert.assertEquals("Error msg was not same", actual, expected);
        closeWebDriver();

    }
    @And("User Enters invalid Password")
    public void userEntersInvalidPassword() {
        // webDriver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("");
        loginPage.userNameTextBox.sendKeys("");

    }

    @Then("verify User Gets empty Password error msg")
    public void verifyUserGetsEmptyPasswordErrorMsg() {
        //  String actual = webDriver.findElement(By.xpath("  //span[@id='spanMessage']")).getText();
        String actual =loginPage.loginErrorMsg.getText();
        String expected = "Password cannot be empty";
        Assert.assertEquals("Error msg was not same", actual, expected);
        closeWebDriver();
    }
    @When("User enters username {string}")
    public void user_enters_username(String userName) {
        loginPage.userNameTextBox.sendKeys(userName);
    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.passwordTextBox.sendKeys(password);
    }
    @Then("user will see {string}")
    public void user_will_see(String expected) {
        String actual =loginPage.loginErrorMsg.getText();
        Assert.assertEquals("Error msg was not same", actual, expected);
    }

}
