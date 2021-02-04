package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@tagSparta",
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/reports/XMLReport.html"}
)
public class TestRunner {
}
