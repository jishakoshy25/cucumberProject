package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import steps.CommonUtils;

public class EbayAdvancedSearchPage {

	WebDriver driver;

	@FindBy(css = "a.gh-logo")
	public WebElement ebayLogo;

	@FindBy(css = "input#_nkw")
	public WebElement keyword;

	@FindBy(css = "input#_ex_kw")
	public WebElement excludeKeyword;

	@FindBy(xpath = "//input[@name='_udlo']")
	public WebElement minimumPrice;

	@FindBy(xpath = "//input[@name='_udhi']")
	public WebElement maximumPrice;

	@FindBy(css = "div.adv-form__actions >button.btn.btn--primary")
	public WebElement searchButton;

	public EbayAdvancedSearchPage(CommonUtils commonUtils) {
		this.driver = commonUtils.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void clickEbayLogo() {
		ebayLogo.click();
	}
	
	public void enterKeyword(String keywordText) {
		keyword.sendKeys(keywordText);
	}
	
	public void enterExcludeCriteria(String excludeText) {
		excludeKeyword.sendKeys(excludeText);
	}
	
	public void enterMinPrice(String minPrice) {
		minimumPrice.sendKeys(minPrice);
	}
	
	public void enterMaxPrice(String maxPrice) {
		maximumPrice.sendKeys(maxPrice);
	}
	
	public void clickSearchBtn() {
		searchButton.click();
	}

}
