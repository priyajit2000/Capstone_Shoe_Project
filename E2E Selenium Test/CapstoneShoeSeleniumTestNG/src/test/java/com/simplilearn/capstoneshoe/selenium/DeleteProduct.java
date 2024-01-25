package com.simplilearn.capstoneshoe.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteProduct {

    WebDriver driver;
    String baseUrl = "http://localhost:9010/delete-shoe?id=101";

    @BeforeTest
    public void setUp() {
        // Set the path of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "DRIVERS/WIN/chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Navigate to the base URL
        driver.get(baseUrl);
    }

    @Test
    public void testDeleteShoe() {
        // Locate the delete button and click it
        WebElement deleteButton = driver.findElement(By.id("deleteButton"));
        deleteButton.click();

        // Wait for the deletion confirmation message
        WebElement deletionMessage = driver.findElement(By.id("deletionMessage"));

        // Validate the deletion message
        Assert.assertEquals(deletionMessage.getText(), "Shoe successfully deleted", "Deletion message doesn't match");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
