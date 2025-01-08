Feature: Get a cart with cartId for the Simple Grocery Store Collection

  Scenario: Get a cart
    When a GET call is made to the single cart endpoint "https://simple-grocery-store-api.glitch.me/carts/{cartId}" with cartId "-kB1mSotZHPDoAU3dxRlw"
    And response code should be 200
    Then print the response payload