package com.simplilearn.capstonerestassured.shoes;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Update_Product {

    private static final String BASE_URL = "http://localhost:9010";
    private static final String UPDATE_PRODUCT_ENDPOINT = "/update-shoe";

    @Test
    public void testUpdateProduct() {
        // Set the base URI for the REST Assured
        RestAssured.baseURI = BASE_URL;

        // Define request parameters for updating the product
        String id = "101"; // specify the ID of the product to update
        String updatedImage = "1.png";
        String updatedName = "BlueWave Running shoes";
        String updatedCategory = "SportsShoes";
        String updatedSizes = "7,8,9";
        String updatedPrice = "1500";

        // Perform the PUT request to update the product
        Response response = given()
                .contentType(ContentType.URLENC)
                .param("id", id)
                .param("image", updatedImage)
                .param("name", updatedName)
                .param("category", updatedCategory)
                .param("sizes", updatedSizes)
                .param("price", updatedPrice)
            .when()
                .put(UPDATE_PRODUCT_ENDPOINT);

        // Assertions
        response.then().statusCode(200); // Assuming 200 is the expected status code for success

    }
}


