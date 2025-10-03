package pages;

import org.openqa.selenium.WebDriver;

import steps.CommonUtils;

public class CommonActions {
	
	private WebDriver driver;
	
	public CommonActions(CommonUtils commonUtils){
		this.driver = commonUtils.getDriver();
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public void quitDriver() {
		driver.quit();
	}

}
