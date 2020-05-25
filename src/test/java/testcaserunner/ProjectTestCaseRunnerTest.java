package testcaserunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features =  "src/test/java/feature",
		glue = {"stepdefination", "hooks"},
		tags = {"@Outline"},
		plugin = {"pretty",
				"html:target/reports/html",
				"json:target/reports/jsonreport.json"},
		monochrome = true,
		dryRun = false
		
)
public class ProjectTestCaseRunnerTest {

}
