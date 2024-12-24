Feature: Add an item to cart for the Simple Grocery Store Collection

  Scenario: Add an item to cart
    Given I have request payload to add an item to cart
    When a POST call is made to the add cart endpoint "https://simple-grocery-store-api.glitch.me/carts/{cartId}/items" with cartId "x4rl_q8T_pr0gUyozUjXc"
    And response code should be 201
    Then capture the itemId from the response
    # Deleted the item added to the cart so that next time you will be free to running this feature file