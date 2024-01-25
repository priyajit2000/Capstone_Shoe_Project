package com.simplilearn.capstoneshoe.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationPageTest {

    WebDriver driver;
    String baseUrl = "http://localhost:9010/register-user";

    @BeforeTest
    public void setUp() {
        // Set the path of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "DRIVERS/WIN/chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Navigate to the base URL
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void testRegisterUserPageTitle() {
        // Get the page title
        String pageTitle = driver.getTitle();

        // Validate the page title
        Assert.assertNotEquals(pageTitle, "localhost:9010/register-user", "Page title doesn't match");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
