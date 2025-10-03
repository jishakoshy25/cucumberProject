package steps;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonActions;
import pages.EbayHomePage;

public class EbayHome_Steps {
	CommonActions commonActions;
	EbayHomePage ebayHomePage;

	public EbayHome_Steps(CommonActions commonActions, EbayHomePage ebayHomePage) {
		this.commonActions = commonActions;
		this.ebayHomePage = ebayHomePage;
	}

	@Given("I am on ebay home page")
	public void i_am_on_ebay_home_page() {
		System.out.println("I am on ebay home page");
		commonActions.openUrl("https://www.ebay.com/");
	}

	@When("I click on Advanced search link")
	public void i_click_on_advanced_search_link() {
		System.out.println("I click on Advanced search link");
		ebayHomePage.clickAdvancedLink();
	}

	@Then("I navigate to Advanced Search page")
	public void i_navigate_to_advanced_search_page() {
		System.out.println("I navigate to Advanced Search page");
		String expectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
		assertEquals(expectedUrl, commonActions.getUrl());

	}

	@When("I search for {string}")
	public void i_search_for_iphone(String keyword) {
		ebayHomePage.enterSearchKeyword(keyword);
		ebayHomePage.clickSearchBtn();
	}

	@When("I search for {string} in {string} category")
	public void i_search_for_in_category(String keyword, String category) {
		ebayHomePage.enterSearchKeyword(keyword);
		ebayHomePage.clickSpecificCategory(category);
		ebayHomePage.clickSearchBtn();
	}

	@Then("I validate that the search results count is atleast {int}")
	public void i_validate_that_the_search_results_count_is_atleast(int expectedCount) {
		waitForPageLoad();
		String text = ebayHomePage.getSearchResultsCount().trim();
		String searchCount = text.replace(",", "");
		int count = Integer.parseInt(searchCount);
		assertTrue(count >= expectedCount);
	}

	@When("I click on {string}")
	public void i_click_on(String linkText) {
		ebayHomePage.clickLink(linkText);
	}

	@Then("I navigate to {string} and the page title contains {string}")
	public void i_navigate_to_and_the_page_title_contains(String url, String title) {
		String actualURL = commonActions.getUrl();
		String actualTitle = commonActions.pageTitle();
		assertEquals(url, actualURL);
		assertTrue(actualTitle.contains(title));

	}

	private void waitForPageLoad() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
