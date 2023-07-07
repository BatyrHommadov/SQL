package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@smoke",
        plugin = {"pretty","html:target/report.html",
                "json:target/jsonReports.json"}

)
public class Smoke {
}
