package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.WebDriverUtils;

public class Hooks extends WebDriverUtils {
   /* @Before
    public void beforeScenario() {

    }
    @After
    public void afterScenario(Scenario scenario) {
        byte [] pic;
        if(scenario.isFailed()){
            pic=takeScreenshot("Failed/"+scenario.getName());
        }else {
            pic=takeScreenshot("Passed/"+scenario.getName());
        }
        scenario.attach(pic,"image/png", scenario.getName());

        closeWebDriver();*/
    }

