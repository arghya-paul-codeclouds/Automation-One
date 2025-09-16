package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import utils.ExtentManager;

public class Hooks extends WebDriverManager {
	@Before
	public void setUp(Scenario scenario) {
		ExtentManager.createTest(scenario.getName());
		// Launch the browser
		initializeBrowser();
		// Go to the Log In page
		goToLoginPage();
	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("In @After hook:");
		System.out.println("Scenario ID: " + scenario.getId());
		System.out.println("Scenario Name: " + scenario.getName());
		System.out.println("Scenario Line Number: " + scenario.getLine());
		System.out.println("Scenario Tag Name(s): " + scenario.getSourceTagNames());
		System.out.println("Scenario Status: " + scenario.getStatus());
		System.out.println("Scenario Uri: " + scenario.getUri());
		if (scenario.isFailed()) {
			System.out.println("In Failed if block");
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png",
					scenario.getName() + "After_" + scenario.getLine() + "_" + System.currentTimeMillis());
			ExtentManager.getTest().fail("Scenario Failed").addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		}
		driver.quit();
	}

	@Before("@before")
	public void tag_before() {
		System.out.println("In Before tag$$$$$$$$$$$$");
	}

	@After("@after")
	public void tag_after() {
		System.out.println("In After tag$$$$$$$$$$$$");
	}

	@Before(order = 2)
	public void b_before() {
		System.out.println("In Before B");
	}

	@Before(order = 1)
	public void a_before() {
		System.out.println("In Before A");
	}

	@Before(order = 3)
	public void c_before() {
		System.out.println("In Before C");
	}

	@After(order = 1)
	public void a_after() {
		System.out.println("In After A");
	}

	@After(order = 2)
	public void b_after() {
		System.out.println("In After B");
	}

	@After(order = 3)
	public void c_after() {
		System.out.println("In After C");
	}

	@BeforeStep
	public void beforeStep(Scenario scenario) {

	}

	@AfterStep
	public void afterStep(Scenario scenario) {

	}

}
