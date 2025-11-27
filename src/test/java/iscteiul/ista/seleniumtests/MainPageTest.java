package iscteiul.ista.seleniumtests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Espera explícita de 5s
        driver.get("https://www.jetbrains.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Espera explícita de 5s

        mainPage = new MainPage(driver);
        mainPage.acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.searchButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mainPage.searchButton);
        mainPage.searchButton.click();

        WebElement searchField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-test$='inner']"))
        );

        searchField.sendKeys("Selenium");
        assertEquals("Selenium", searchField.getAttribute("value"));
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(mainPage.findYourToolsButton.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(mainPage.findYourToolsButton));

        try {
            mainPage.findYourToolsButton.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainPage.findYourToolsButton);
        }

        WebElement productsList = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("products-page"))
        );
        assertTrue(productsList.isDisplayed());
        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
    }
}