package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Tagged_Hooks {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	@Before(value = "@setCookies", order = 1)
	public void scenarioSpecificBeforeHook() {
		System.out.println("Scenario specific before hook");
	}

	@After(value = "@t1", order = 1)
	public void scenarioSpecificAfterHook() {
		System.out.println("Scenario specific after hook");
	}
}
