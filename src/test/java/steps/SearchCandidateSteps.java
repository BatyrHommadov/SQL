package steps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import utils.WebDriverUtils;

public class SearchCandidateSteps extends WebDriverUtils {
    @When("user clicks on recruitment tab")
    public void user_clicks_on_recruitment_tab() {
        recruitmentPage.recruitmentTab.click();
    }

    @When("user clicks on job title drop down and selects {string}")
    public void user_clicks_on_job_title_drop_down_and_selects(String string) {
        Select select = new Select(recruitmentPage.findByTitleDD);
        select.selectByIndex(1);

    }

    @When("user clicks on the search button")
    public void user_clicks_on_the_search_button() {
    recruitmentPage.searchBtn.click();
    }

    @When("verifies the candidate")
    public void verifies_the_candidate() {
        String actual =recruitmentPage.searchResult.getText();
        String expected = "abhishek kumar yadav";
        Assert.assertEquals("Search result was not same", actual, expected);
    }
}
