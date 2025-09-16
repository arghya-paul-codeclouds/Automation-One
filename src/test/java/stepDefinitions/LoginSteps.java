package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import hooks.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends WebDriverManager {
	@When("user enters {string} and {string}")
	public void userEntersCredentials(String username, String password) {
		extectedUsername = username;
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
	}

	@When("user clicks the login submit button")
	public void userClicksTheLoginSubmitButton() {
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	}

	@Then("user sees the Dashboard")
	public void userSeesTheDashboard() throws InterruptedException {
		Thread.sleep(2000);
		String username = driver.findElement(By.xpath("(//span[@class='mdc-button__label'])[2]")).getText();
		Assert.assertEquals(username.trim(), extectedUsername, "Dashboard page");
	}

	@Then("user remains on the login page")
	public void userRemainsOnTheLoginPage() throws InterruptedException {
		String expectedUsername = "Login";
		Thread.sleep(2000);
		String username = driver.findElement(By.xpath("(//span[@class='mdc-button__label'])[2]")).getText();
		Assert.assertEquals(username.trim(), expectedUsername, "Login page");
	}

}
