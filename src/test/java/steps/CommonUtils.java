package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUtils {

	private WebDriver driver;

	@Before(order=0)
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Global before hook");
	}

	@After(order=0)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		driver.quit();
		System.out.println("Global after hook");
	}

	public WebDriver getDriver() {
		return driver;
	}
}
