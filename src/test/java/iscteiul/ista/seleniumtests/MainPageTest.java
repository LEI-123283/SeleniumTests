package iscteiul.ista.seleniumtests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jetbrains.com/");

        mainPage = new MainPage(driver);
        mainPage.acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        mainPage.searchButton.click();

        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); } // espera

        WebElement searchField = driver.findElement(By.cssSelector("input[data-test$='inner']"));
        searchField.sendKeys("Selenium");

        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // espera para ver o texto escrito

        assertEquals("Selenium", searchField.getAttribute("value"));
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();

        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        assertTrue(mainPage.findYourToolsButton.isDisplayed(),
                "O menu abriu mas o botão 'suggestion-link' (Find Your Tools) não está visível.");
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        WebElement productsList = driver.findElement(By.id("products-page"));
        assertTrue(productsList.isDisplayed());
        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
    }
}
