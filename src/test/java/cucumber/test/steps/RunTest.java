+*+
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(monochrome = true, plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json" },
        tags = {"@dvla_datadriver"},features = "src/test/resources/feature")
public class -//RunTest extends AbstractTestNGCucumberTests {

        }


