Feature: Test API Endpoint - Get Users

  Scenario: Retrieve a list of users from the API
    Given the API endpoint is "http://localhost:9010/get-users"
    When I send a GET request to the API
    Then the response status code should be 200
    And the response should contain a list of users
    And each user in the list should have an "id", "username", "email", and "role"

  Scenario Outline: Retrieve details of a specific user by ID
    Given the API endpoint is "http://localhost:9010/get-users"
    When I send a GET request to the API with the user ID "<userId>"
    Then the response status code should be 200
    And the response should contain details for the user with ID "<userId>"
    And the details should include "username", "email", and "role"

    Examples:
      | userId |
      | 1      |
      | 2      |
      | 3      |
