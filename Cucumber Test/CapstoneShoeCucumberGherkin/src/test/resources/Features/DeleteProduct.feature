  Feature: Test API Endpoint - Delete Shoe

  Scenario: Delete a shoe using the API
    Given the API endpoint is "http://localhost:9010/delete-shoe"
    And there is an existing shoe with ID 101
    When I send a DELETE request to the API with the shoe ID 101
    Then the response status code should be 200
    And the response should contain a success message indicating the shoe deletion

  Scenario: Attempt to delete a non-existing shoe
    Given the API endpoint is "http://localhost:9010/delete-shoe"
    And there is no shoe with ID 999
    When I send a DELETE request to the API with the shoe ID 999
    Then the response status code should be 404
    And the response should contain an error message indicating that the shoe was not found
  