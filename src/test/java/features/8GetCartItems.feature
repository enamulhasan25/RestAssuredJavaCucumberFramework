Feature: Get cart items list with cartId for the Simple Grocery Store Collection

  Scenario: Get cart items
    When a GET call is made to the single cart endpoint "https://simple-grocery-store-api.glitch.me/carts/{cartId}/items" with cartId "5VS4On_jauLABNtmz6t1p"
    And response code should be 200
    Then print the response payload

    # For this feature file no need step definition GetCartWithCartId class is enough.