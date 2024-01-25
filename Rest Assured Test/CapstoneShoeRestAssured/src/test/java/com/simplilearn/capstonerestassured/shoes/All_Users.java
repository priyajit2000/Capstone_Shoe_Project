package com.simplilearn.capstonerestassured.shoes;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class All_Users {

    private static final String BASE_URL = "http://localhost:9010";
    private static final String GET_USERS_ENDPOINT = "/get-users";

    @Test
    public void testGetAllUsers() {
        // Set the base URI for the REST Assured
        RestAssured.baseURI = BASE_URL;

        // Perform the GET request to get all users
        Response response = get(GET_USERS_ENDPOINT);

        // Assertions
        response.then().statusCode(200); // Assuming 200 is the expected status code for success

        
        // Example: Check if the response contains at least one user
        response.then().body("users", not(empty()));
    }
}

