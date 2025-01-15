Feature: Get a cart with cartId for the Simple Grocery Store Collection

  Scenario: Get a cart
    When a GET call is made to the single cart endpoint "https://simple-grocery-store-api.glitch.me/carts/{cartId}" with cartId "5VS4On_jauLABNtmz6t1p"
    And response code should be 200
    Then print the response payload