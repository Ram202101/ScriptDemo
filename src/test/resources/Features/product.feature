Feature: Validation Scenario

  @MyDemo
  Scenario: Validate lowest price from product wish list is added to cart
    Given add the first product
    When I view my wishlist table
    Then I find total four selected items in my Wishlist
    When I search for lowest price product
    And I am able to add the lowest price item to my cart
    Then I am able to verify the item in my cart
