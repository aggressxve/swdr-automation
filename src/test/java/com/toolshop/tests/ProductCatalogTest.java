package com.toolshop.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductCatalogTest {
    private WebDriver driver;
    private static final String BASE_URL = "https://practicesoftwaretesting.com/";

    @BeforeEach
    void setUp() {
         driver = new ChromeDriver();
    }

    @Test
    void shouldDisplayProducts() {
        driver.get(BASE_URL);
        By productCardLocator = By.cssSelector("h5.card-title");
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        List<WebElement> productNames = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productCardLocator)
        );

        assertTrue(
                !productNames.isEmpty(),
                "Expected at least one product to be displayed"
        );

        for(WebElement product : productNames) {
            String name = product.getText();

            System.out.println("Product: " + name);

            assertTrue(
                    !name.isEmpty(),
                    "A product has an empty name"
            );
        }

        int productQuantity = productNames.size();
        assertTrue(productQuantity > 0);
    }

    @Test
    void shouldDisplayProductNamesAndPrices() {
        // TODO 1: Define the locator for the parent cards
        // TODO 2: Wait until cards appear
        // TODO 3: Retrieve the List<WebElement>
        // TODO 4: Loop through each product card
        // TODO 5: Find the product name inside the card
        // TODO 6:  Find the product price inside the card
        // TODO 7: Retrieve both values using getText()
        // TODO 8: Print the values
        // TODO 9: Assert neither is empty
        driver.get(BASE_URL);
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
        By productCardsLocator = By.cssSelector("a.card");
        List<WebElement> productCards = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productCardsLocator)
        );

        for(WebElement card : productCards) {
            WebElement nameElement = card.findElement(By.cssSelector("h5.card-title"));
            WebElement priceElement = card.findElement(By.cssSelector("[data-test='product-price']"));
            String name = nameElement.getText();
            String price = priceElement.getText();
            assertTrue(
                    !name.isEmpty(),
                    "Name is empty."
            );
            assertTrue(
                    !price.isEmpty(),
                    "Price is empty"
            );
            System.out.println("Name: " + name);
            System.out.println("Price: " + price);
        }

    }

    @Test
    void shouldOpenCorrectProductDetails() {
        driver.get(BASE_URL);
        // TODO 1: Locate the first visible product card
        // TODO 2: Save its product name
        // TODO 3: Click its navigation link
        // TODO 4: Wait for the product details page
        // TODO 5: Retrieve the details page product name
        // TODO 6: Compare both names with assertEquals()
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
        By productCardsLocator = By.cssSelector("a.card");

        WebElement productCard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(productCardsLocator)
        );

        WebElement nameElement = productCard.findElement(By.cssSelector("h5.card-title"));
        String name = nameElement.getText();

        assertTrue(
                !name.isEmpty(),
                "Name of selected card is empty"
        );

        productCard.click();
        By productDetailTitleLocator = By.cssSelector("h1[data-test='product-name']");

        WebElement productTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(productDetailTitleLocator)
        );

        String productDetailName = productTitle.getText();

        assertEquals(name, productDetailName);

    }


    @AfterEach
    void tearDown()
    {
        if(driver != null) driver.quit();
    }

}
