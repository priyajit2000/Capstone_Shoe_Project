Feature: Test API Endpoint - Update Shoe

  Scenario: Update the details of an existing shoe using the API
    Given the API endpoint is "http://localhost:9010/update-shoe?id=101&image=1.png&name=BlueWave Running shoes&category=SportsShoes&sizes=7,8,9&price=1500"
    And there is an existing shoe with ID 101
    When I send a PUT request to the API with the following details for shoe ID 101:
      | image_url_updated | name_updated  | category_updated | sizes_updated | price_updated |
      | updated_image_url | UpdatedShoe   | Walking          | 10            | 1200          |
    Then the response status code should be 200
    And the response should contain the updated details for the shoe with ID 101
    And the details should include "id", "image_url", "name", "category", "sizes", and "price"

  Scenario: Attempt to update a non-existing shoe
    Given the API endpoint is "http://localhost:9010/update-shoe?id=101&image=1.png&name=BlueWave Running shoes&category=SportsShoes&sizes=7,8,9&price=1500"
    And there is no shoe with ID 999
    When I send a PUT request to the API with the following details for shoe ID 999:
      | image_url | NonExistingShoe | Running  | 9  | 1000  |
    Then the response status code should be 404
    And the response should contain an error message indicating that the shoe was not found

