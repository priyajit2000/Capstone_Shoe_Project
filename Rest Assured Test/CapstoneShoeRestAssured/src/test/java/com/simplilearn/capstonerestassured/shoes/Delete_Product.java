package com.simplilearn.capstonerestassured.shoes;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Delete_Product {

    private static final String BASE_URL = "http://localhost:9010";
    private static final String DELETE_PRODUCT_ENDPOINT = "/delete-shoe";

    @Test
    public void testDeleteProduct() {
        // Set the base URI for the REST Assured
        RestAssured.baseURI = BASE_URL;

        // Define request parameter
        String id = "101";

        // Perform the DELETE request to delete a product
        Response response = delete(DELETE_PRODUCT_ENDPOINT + "?id=" + id);

        
        response.then().statusCode(200); // Assuming 200 is the expected status code for success

    }
}

