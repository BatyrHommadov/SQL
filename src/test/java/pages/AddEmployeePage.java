package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

public class AddEmployeePage extends WebDriverUtils {
    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='middleName']")
    public WebElement middleName;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement saveBtn;
    @FindBy(xpath = "//input[@id='employeeId']")
    public WebElement employeeId;

    public AddEmployeePage(){
        PageFactory.initElements(webDriver,this);
    }
}
