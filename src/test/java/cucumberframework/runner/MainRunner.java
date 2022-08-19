package cucumberframework.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = {"src/test/java/cucumberframework/featurefiles"},
		glue = {"cucumberframework.steps"},
		//monochrome = true,
		plugin = {"pretty", "html:targetReport/cucumber", "json:targetReport/cucumber.json" }
		)
public class MainRunner {

}
