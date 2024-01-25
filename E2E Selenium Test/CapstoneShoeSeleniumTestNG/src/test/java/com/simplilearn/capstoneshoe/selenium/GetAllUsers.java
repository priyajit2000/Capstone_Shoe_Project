package com.simplilearn.capstoneshoe.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetAllUsers {

    WebDriver driver;
    String baseUrl = "http://localhost:9010/get-users";

    @BeforeTest
    public void setUp() {
    
        System.setProperty("webdriver.chrome.driver", "DRIVERS/WIN/chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Navigate to the base URL
        driver.get(baseUrl);
    }

    @Test
    public void testUsersPageTitle() {
        // Get the page title
        String pageTitle = driver.getTitle();

        // Validate the page title
        Assert.assertNotEquals(pageTitle, "localhost:9010/get-users", "Page title doesn't match");
    }

    @Test
    public void testUsersPageContent() {
        
        WebElement shoesContent = driver.findElement(By.xpath("/html/body/pre"));

        // Validate the content of the element
        Assert.assertTrue(shoesContent.isDisplayed(), "Shoes content is not displayed");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}


