Feature: Advanced Search Page

  @P1
  Scenario: Ebay logo on Advanced Search Page
    Given I am on Ebay Advanced Search Page
    When I click on ebay Logo
    Then I navigate to ebay home page

  @P11 @setCookies @t1
  Scenario: Advanced Search an item
    Given I am on Ebay Advanced Search Page
    When I do an advanced search for an item
      | keyword   | exclude     | min | max |
      | iPhone 11 | refurbished | 300 | 900 |
