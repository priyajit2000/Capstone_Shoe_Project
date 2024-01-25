package com.simplilearn.capstonerestassured.shoes;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Add_Product {

    private static final String BASE_URL = "http://localhost:9010";
    private static final String ADD_PRODUCT_ENDPOINT = "/add-shoe";

    @Test
    public void testAddProduct() {
        // Set the base URI for the REST Assured
        RestAssured.baseURI = BASE_URL;

        
        String id = "101";
        String image = "image_url";
        String name = "SampleShoe";
        String category = "Running";
        String sizes = "9";
        String price = "1000";

        // Perform the POST request to add a product
        Response response = given()
                .contentType(ContentType.URLENC)
                .param("id", id)
                .param("image", image)
                .param("name", name)
                .param("category", category)
                .param("sizes", sizes)
                .param("price", price)
            .when()
                .post(ADD_PRODUCT_ENDPOINT);

        // Assertions
        response.then().statusCode(200); // Assuming 200 is the expected status code for success

    }
}

