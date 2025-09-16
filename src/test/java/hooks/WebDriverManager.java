package hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	protected static WebDriver driver;
	protected static String extectedUsername;

	public void initializeBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://bookcart.azurewebsites.net/");
	}

	public void goToLoginPage() {
		driver.findElement(By.xpath("//span[text()=' Login ']")).click();
	}
}
