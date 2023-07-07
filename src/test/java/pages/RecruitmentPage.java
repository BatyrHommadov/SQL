package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

public class RecruitmentPage extends WebDriverUtils {

    @FindBy(xpath = "//b[normalize-space()='Recruitment']")
    public WebElement recruitmentTab;
    @FindBy(xpath = "//select[@id='candidateSearch_jobTitle']")
    public WebElement findByTitleDD;
    @FindBy(xpath = "//input[@id='btnSrch']")
    public WebElement searchBtn;
    @FindBy(xpath = "//a[normalize-space()='abhishek kumar yadav']")
    public WebElement searchResult;
    public RecruitmentPage(){
        PageFactory.initElements(webDriver,this);
    }
}
