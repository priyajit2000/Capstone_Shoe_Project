Feature: Test API Endpoint - Add Shoe

  Scenario: Add a new shoe using the API
    Given the API endpoint is "http://localhost:9010/add-shoe"
    When I send a POST request to the API with the following details:
      | id    | image_url     | name       | category | sizes | price |
      | 101   | image_url     | SampleShoe | Running  | 9     | 1000  |
    Then the response status code should be 201
    And the response should contain the details for the added shoe
    And the details should include "id", "image_url", "name", "category", "sizes", and "price"

  Scenario: Attempt to add a shoe with an existing ID
    Given the API endpoint is "http://localhost:9010/add-shoe"
    And there is an existing shoe with ID 101
    When I send a POST request to the API with the following details:
      | id    | image_url     | name       | category | sizes | price |
      | 101   | image_url     | Duplicate  | Running  | 9     | 1000  |
    Then the response status code should be 400
    And the response should contain an error message indicating that the ID is already in use

