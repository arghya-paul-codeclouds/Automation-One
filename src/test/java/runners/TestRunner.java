package runners;

import org.testng.annotations.AfterSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import utils.ExtentManager;

@CucumberOptions(features = {
		"src/test/java/Features/addToCart.feature" }, dryRun = !true, snippets = SnippetType.CAMELCASE, glue = {
				"hooks", "stepDefinitions" }, plugin = { "pretty", "html:Reports/my-report.html",
						"json:Reports/my-report.json", "junit:Reports/my-report.xml" })
public class TestRunner extends AbstractTestNGCucumberTests {
	@AfterSuite
	public void generateReport() {
		ExtentManager.flush();
	}
}
