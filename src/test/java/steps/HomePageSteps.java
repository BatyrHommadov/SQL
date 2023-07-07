package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.WebDriverUtils;

import java.util.List;

public class HomePageSteps extends WebDriverUtils {


    @Then("User verifies all Tabs are available")
    public void user_verifies_all_tabs_are_available(io.cucumber.datatable.DataTable dataTable) {

        List<String> expectedTabs=dataTable.transpose().asList();
        List<WebElement> actualTabs=homePage.homePageTabs;
        for (int i = 0; i < expectedTabs.size(); i++) {

            Assert.assertEquals("Tab didn't match",expectedTabs.get(i),actualTabs.get(i).getText());
        }

    }
}
