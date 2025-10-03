package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonActions;
import pages.EbayAdvancedSearchPage;

public class EbayAdvancedSearch_Steps {
	CommonActions commonActions;
	EbayAdvancedSearchPage ebayAdvancedSearchPage;

	public EbayAdvancedSearch_Steps(CommonActions commonActions, EbayAdvancedSearchPage ebayAdvancedSearchPage) {
		this.commonActions = commonActions;
		this.ebayAdvancedSearchPage = ebayAdvancedSearchPage;
	}

	@Given("I am on Ebay Advanced Search Page")
	public void i_am_on_ebay_advanced_search_page() {
		System.out.println("I am on Ebay Advanced Search Page");
		commonActions.openUrl("https://www.ebay.com/sch/ebayadvsearch");
	}

	@When("I click on ebay Logo")
	public void i_click_on_ebay_logo() {
		System.out.println("I click on ebay Logo");
		ebayAdvancedSearchPage.clickEbayLogo();
	}

	@Then("I navigate to ebay home page")
	public void i_navigate_to_ebay_home_page() {
		System.out.println("I navigate to ebay home page");
		String expectedUrl = "https://www.ebay.com/";
		assertEquals(expectedUrl, commonActions.getUrl());
	}

	@When("I do an advanced search for an item")
	public void i_do_an_advanced_search_for_an_item(io.cucumber.datatable.DataTable dataTable) throws Exception {
		ebayAdvancedSearchPage.enterKeyword(dataTable.cell(1, 0));
		ebayAdvancedSearchPage.enterExcludeCriteria(dataTable.cell(1, 1));
		ebayAdvancedSearchPage.enterMinPrice(dataTable.cell(1, 2));
		ebayAdvancedSearchPage.enterMaxPrice(dataTable.cell(1, 3));
		ebayAdvancedSearchPage.clickSearchBtn();
		Thread.sleep(5000);
	}

}
