package com.toolshop.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductSearchTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final String BASE_URL =
            "https://practicesoftwaretesting.com/";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void shouldSearchForExistingProduct() {
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
        String search = "pliers";
        By searchInputLocator = By.id("search-query");
        By searchButtonLocator = By.cssSelector("[data-test='search-submit']");
        By productNamesLocator = By.cssSelector("h5.card-title");
        driver.get(BASE_URL);

        executeSearch(search, false);

        List<WebElement> productResultNames = wait.until(d -> {
           List<WebElement> products = d.findElements(productNamesLocator);

           if(products.isEmpty()){
               return null;
           }

           Boolean productNamesLoaded = products.stream().allMatch(
                   element -> element.isDisplayed()
                           && !element.getText().isBlank()
                           && element.getText().toLowerCase().contains(search)
           );

           return productNamesLoaded ? products : null;
        });

        assertFalse(productResultNames.isEmpty());

        for(WebElement product : productResultNames) {
            String productName = product.getText();
            System.out.println("Product: " + productName);
        }

    }

    @Test
    void shouldSearchUsingEnterKey() {
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
        String search = "pliers";
        By productNamesLocator = By.cssSelector("h5.card-title");
        driver.get(BASE_URL);

        executeSearch(search, true);

        List<WebElement> productResultNames = wait.until(d -> {
            List<WebElement> products = d.findElements(productNamesLocator);

            if(products.isEmpty()){
                return null;
            }

            Boolean productNamesLoaded = products.stream().allMatch(
                    element -> element.isDisplayed()
                            && !element.getText().isBlank()
                            && element.getText().toLowerCase().contains(search)
            );

            return productNamesLoaded ? products : null;
        });

        assertFalse(productResultNames.isEmpty());

        for(WebElement product : productResultNames) {
            String productName = product.getText();
            System.out.println("Product: " + productName);
        }

    }


    @Test
    void shouldDisplayNoResultsForNonexistentProduct() {
        driver.get(BASE_URL);
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
        String search = "zz-no-match-98431";
        By noResultsLocator = By.cssSelector("[data-test='no-results']");
        By cardsLocator = By.cssSelector("h5.product-card");

        executeSearch(search, false);

        String noResultsText = wait.until(d -> {
            WebElement element = driver.findElement(noResultsLocator);

            String elementText = element.getText();

            return elementText.isBlank() ? null : elementText;
        });

        assertEquals("There are no products found.", noResultsText);

        List<WebElement> productCards = driver.findElements(cardsLocator);
        assertTrue(productCards.size() == 0);

    }


    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void executeSearch(String entry, boolean usingEnter) {
        By searchInputLocator = By.id("search-query");
        By searchButtonLocator = By.cssSelector("[data-test='search-submit']");

        WebElement searchInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchInputLocator)
        );

        WebElement searchButton = wait.until(
                ExpectedConditions.elementToBeClickable(searchButtonLocator)
        );

        searchInput.sendKeys(entry);

        String searchValue = searchInput.getDomProperty("value");
        assertEquals(entry, searchValue);

        if(usingEnter) {
            searchInput.sendKeys(Keys.ENTER);
        } else {
            searchButton.click();
        }
    }

}