Feature: Create a new cart for the Simple Grocery Store Collection

  Scenario: Create New Cart
    When a POST call without is made to the 'https://simple-grocery-store-api.glitch.me/carts'
    And response code should be 201
    Then capture the cartId from the response