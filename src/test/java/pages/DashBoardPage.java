package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

public class DashBoardPage extends WebDriverUtils {
    @FindBy(xpath = "//b[normalize-space()='Dashboard']")
    public WebElement dashBoard;

    @FindBy(xpath = "//b[normalize-space()='PIM']")
    public WebElement pimBtn;

    @FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
    public WebElement addEmployee;

   // public WebElement leaveType=selectDDByIndex(leaveTypeDD, 1);




    public DashBoardPage(){
        PageFactory.initElements(webDriver,this);
    }
}
