package com.simplilearn.capstoneshoe.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddProduct {

    WebDriver driver;
    String baseUrl = "http://localhost:9010/add-shoe?id=101&image=image_url&name=SampleShoe&category=Running&sizes=9&price=1000";

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
    public void testAddShoe() {
        // Get the form elements and populate them
        WebElement shoeNameInput = driver.findElement(By.id("name"));
        WebElement shoeCategoryInput = driver.findElement(By.id("category"));
        WebElement shoeSizesInput = driver.findElement(By.id("sizes"));
        WebElement shoePriceInput = driver.findElement(By.id("price"));
        WebElement addimage = driver.findElement(By.id("image"));

        shoeNameInput.sendKeys("SampleShoe");
        shoeCategoryInput.sendKeys("Running");
        shoeSizesInput.sendKeys("9");
        shoePriceInput.sendKeys("1000");

        // Click the add button
        addimage.click();

        // Wait for the new shoe details to appear on the page
        WebElement addedShoeName = driver.findElement(By.id("addedShoeName"));

        // Validate the added shoe details
        Assert.assertEquals(addedShoeName.getText(), "SampleShoe", "Shoe name doesn't match");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

