package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

public class LoginPage extends WebDriverUtils {
    @FindBy(xpath = "//input[@id='txtUsername']")
    public WebElement userNameTextBox;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='btnLogin']")
    public WebElement loginBtn;

    @FindBy(id = "spanMessage")
    public WebElement loginErrorMsg;


    public LoginPage(){
        PageFactory.initElements(webDriver,this);
    }
}
