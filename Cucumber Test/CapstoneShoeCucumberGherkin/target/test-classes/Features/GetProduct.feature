Feature: Test API Endpoint - Get Shoes

  Scenario: Retrieve a list of shoes from the API
    Given the API endpoint is "http://localhost:9010/get-shoes"
    When I send a GET request to the API
    Then the response status code should be 200
    And the response should contain a list of shoes
    And each shoe in the list should have an "id", "name", "category", "sizes", and "price"

  Scenario Outline: Retrieve details of a specific shoe by ID
    Given the API endpoint is "http://localhost:9010/get-shoes"
    When I send a GET request to the API with the shoe ID "<shoeId>"
    Then the response status code should be 200
    And the response should contain details for the shoe with ID "<shoeId>"
    And the details should include "name", "category", "sizes", and "price"

    Examples:
      | shoeId |
      | 101    |
      | 102    |
      | 103    |

