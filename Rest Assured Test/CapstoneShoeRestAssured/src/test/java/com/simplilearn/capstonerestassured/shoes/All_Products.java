package com.simplilearn.capstonerestassured.shoes;

//public class All_Products {

//}

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class  All_Products{

    private static final String BASE_URL = "http://localhost:9010";
    private static final String GET_SHOES_ENDPOINT = "/get-shoes";

    @Test
    public void testGetAllUsers() {
        // Set the base URI for the REST Assured
        RestAssured.baseURI = BASE_URL;

        // Perform the GET request to get all shoes
        Response response = RestAssured.get(GET_SHOES_ENDPOINT);

        // Assertions
        response.then().statusCode(200); // Assuming 200 is the expected status code for success

  
    }
}

