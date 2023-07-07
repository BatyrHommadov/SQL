package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

public class EmployeeListPage extends WebDriverUtils {
    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement editBtn;


    @FindBy(xpath = "//input[@id='personal_txtLicenNo']")
    public WebElement dlNumber;

    @FindBy(xpath = "//input[@id='personal_txtLicExpDate']")
    public WebElement leDate;

    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    public WebElement empNationality;

    public EmployeeListPage(){
        PageFactory.initElements(webDriver,this);
    }
}
