Feature: Create Client

  Scenario: Register a new client
    Given I have request payload
    When I POST the request to create the client with random string
    Then capture the response payload
    And Will validate status code