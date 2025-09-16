package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import hooks.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps extends WebDriverManager {
	@When("user clicks the {string}")
	public void userClicksThe(String category) {
		List<WebElement> allCategoryElements = driver
				.findElements(By.xpath("//*[@class='mdc-list-item__content']/span"));
		allCategoryElements.parallelStream()
				.filter(allCategoryElement -> allCategoryElement.getText().trim().equalsIgnoreCase(category)).findAny()
				.ifPresent(categoryElement -> categoryElement.click());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

	}

	@Then("the {string} should reflect in the url")
	public void theShouldReflectInTheUrl(String category) {
		String expectedUrl = "https://bookcart.azurewebsites.net/filter?category=" + category.toLowerCase();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, expectedUrl, "URL is not showing the proper category");
	}
	
	@Then("user does nothing")
	public void userDoesNothing() {
		System.out.println("User does nothing!!!!!!!!!!!!!");Assert.assertTrue(false);
	}
}
