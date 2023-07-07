package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

public class PersonalDetailsPage extends WebDriverUtils {
    @FindBy(xpath = "//h1[normalize-space()='Personal Details']")
    public WebElement personalDetails;

    public   PersonalDetailsPage(){
        PageFactory.initElements(webDriver,this);
    }
}
