package com.toolshop.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowserNavigationTest {

    private WebDriver driver;

    private final String BASE_URL =
            "https://practicesoftwaretesting.com/";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void shouldOpenToolshop() {

        // Navigate to our application
        driver.get(BASE_URL);

        // Wait until the expected page title appears
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        wait.until(
                ExpectedConditions.titleContains("Toolshop")
        );

        // Retrieve information
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        driver.navigate().refresh();
        System.out.println(title);

        System.out.println("Title: " + title);
        System.out.println("URL: " + url);

        // Verify the expected behavior
        assertTrue(title.contains("Toolshop"));
        assertTrue(url.startsWith(BASE_URL));
    }

    @Test
    void shouldRefreshToolshop() {
        driver.get(BASE_URL);

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        wait.until(
                ExpectedConditions.titleContains("Toolshop")
        );

        driver.navigate().refresh();

        wait.until(
                ExpectedConditions.titleContains("Toolshop")
        );

        String title = driver.getTitle();

        assertTrue(title.contains("Toolshop"));

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
