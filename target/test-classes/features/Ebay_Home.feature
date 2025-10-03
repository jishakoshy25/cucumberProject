Feature: ebay Home Page feature

  @P2
  Scenario: Advanced Search Link
    Given I am on ebay home page
    When I click on Advanced search link
    Then I navigate to Advanced Search page

  @P3
  Scenario: Validate search results count - iPhone
    Given I am on ebay home page
    When I search for 'iphone 16'
    Then I validate that the search results count is atleast 1000

  @P3
  Scenario: Validate search results count - Toy cars
    Given I am on ebay home page
    When I search for 'Toy cars'
    Then I validate that the search results count is atleast 100

  @P30 @P11
  Scenario: Search for an item in a particular category
    Given I am on ebay home page
    When I search for 'soap' in 'Baby' category
    Then I validate that the search results count is atleast 100

  @P12 @P30
  Scenario Outline: Home Page Links
    Given I am on ebay home page
    When I click on '<link>'
    Then I navigate to '<url>' and the page title contains '<title>'

    Examples: 
      | link          | url                                                            | title                         |
      | Motors        | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334 | eBay Motors                   |
      | Electronics   | https://www.ebay.com/b/Electronics/bn_7000259124               | Electronics products for sale |
      | Home & Garden | https://www.ebay.com/b/Home-Garden/11700/bn_1853126            | Home & Garden products        |
