package com.toolshop.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    private static final String BASE_URL = "https://practicesoftwaretesting.com/";
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }


    @Test
    void shouldDisplayProducts() {
        driver.get(BASE_URL);

        By productNameLocator = By.cssSelector("h5.card-title");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        List<WebElement> productNames = wait.until(d -> {
            List<WebElement> elements = d.findElements(productNameLocator);

            if (elements.isEmpty()) {
                return null;
            }

            boolean allNamesLoaded = elements.stream().allMatch(element -> element.isDisplayed() && !element.getText().isBlank());

            return allNamesLoaded ? elements : null;
        });

        System.out.println("Products found: " + productNames.size());

        for (WebElement product : productNames) {
            String name = product.getText().trim();

            System.out.println("Product: " + name);

            assertTrue(!name.isBlank(), "A product has an empty name");
        }
    }


    @Test
    void shouldDisplayProductNamesAndPrices() {
        driver.get(BASE_URL);

        By cardLocator = By.cssSelector("a.card");
        By nameLocator = By.cssSelector("h5.card-title");
        By priceLocator = By.cssSelector(
                "[data-test='product-price']"
        );

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        List<WebElement> cards = wait.until(d -> {
            List<WebElement> foundCards =
                    d.findElements(cardLocator);

            if (foundCards.isEmpty()) {
                return null;
            }

            for (WebElement card : foundCards) {
                List<WebElement> names =
                        card.findElements(nameLocator);

                List<WebElement> prices =
                        card.findElements(priceLocator);

                if (!card.isDisplayed()
                        || names.isEmpty()
                        || prices.isEmpty()) {
                    return null;
                }

                if (names.get(0).getText().isBlank()
                        || prices.get(0).getText().isBlank()) {
                    return null;
                }
            }

            return foundCards;
        });

        for (WebElement card : cards) {
            String name = card.findElement(nameLocator)
                    .getText().trim();

            String price = card.findElement(priceLocator)
                    .getText().trim();

            System.out.println(name + " - " + price);

            assertTrue(!name.isBlank());
            assertTrue(!price.isBlank());
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By productCardsLocator = By.cssSelector("a.card");

        WebElement productCard = wait.until(ExpectedConditions.visibilityOfElementLocated(productCardsLocator));

        WebElement nameElement = productCard.findElement(By.cssSelector("h5.card-title"));
        String name = nameElement.getText();

        assertTrue(!name.isEmpty(), "Name of selected card is empty");

        productCard.click();
        By productDetailTitleLocator = By.cssSelector("h1[data-test='product-name']");

        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailTitleLocator));

        String productDetailName = productTitle.getText();

        assertEquals(name, productDetailName);

    }


    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }

}
