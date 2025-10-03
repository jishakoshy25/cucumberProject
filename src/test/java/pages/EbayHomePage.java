package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import steps.CommonUtils;

public class EbayHomePage {

	WebDriver driver;
	@FindBy(linkText = "Advanced")
	public WebElement advancedLink;
	
	@FindBy(xpath = "//input[@id = 'gh-ac']")
	public WebElement searchKeyword;
	
	@FindBy(css = "button#gh-search-btn")
	public WebElement searchBtn;
	
	@FindBy(xpath="//select[@id = 'gh-cat']/option")
	public List<WebElement> options;
	
	@FindBy(css = "h1.srp-controls__count-heading>span.BOLD:nth-child(1)")
	public WebElement searchResultsCount;
	
	public EbayHomePage(CommonUtils commonUtils){
		this.driver = commonUtils.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void clickAdvancedLink() {
		advancedLink.click();
	}
	
	public void enterSearchKeyword(String keyword) {
		searchKeyword.sendKeys(keyword);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public void clickSpecificCategory(String category) {
		for(WebElement option: options) {
			if(option.getText().trim().toLowerCase().equals(category.toLowerCase())) {
				option.click();
				break;
			}
		}
	}
	
	public void clickLink(String text) {
		driver.findElement(By.linkText(text)).click();
	}
	
	public String getSearchResultsCount() {
		return searchResultsCount.getText();
	}
}
