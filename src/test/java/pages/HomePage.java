package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

import java.util.List;

public class HomePage extends WebDriverUtils {
    @FindBy(xpath = "//ul[@id='mainMenuFirstLevelUnorderedList']/li")
    public List<WebElement> homePageTabs;

    public HomePage(){
        PageFactory.initElements(webDriver,this);
    }
}
