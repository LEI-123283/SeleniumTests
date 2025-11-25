package iscteiul.ista.seleniumtests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.jetbrains.com/");

        mainPage = new MainPage(driver);
        mainPage.acceptCookies();  //novo
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // -------- TESTE 1: Pesquisar --------
    @Test
    public void search() {
        mainPage.safeClick(mainPage.searchButton);//novo

        WebElement searchField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-test$='inner']"))
        );

        searchField.sendKeys("Selenium");
        assertEquals("Selenium", searchField.getAttribute("value"));
    }

    // -------- TESTE 2: Abrir menu de ferramentas --------
    @Test
    public void toolsMenu() {
        // Clica no menu Tools
        mainPage.safeClick(mainPage.toolsMenu);

        // Espera que um elemento confiável dentro do submenu esteja visível
        WebElement findYourTools = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(mainPage.findYourToolsButton));

        // Verifica se realmente está visível
        assertTrue(findYourTools.isDisplayed());
    }




    // -------- TESTE 3: Navegar para página All Tools --------
    @Test
    public void navigationToAllTools() {

        mainPage.safeClick(mainPage.seeDeveloperToolsButton);
        mainPage.safeClick(mainPage.findYourToolsButton);

        WebElement productsList = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("products-page"))
        );

        assertTrue(productsList.isDisplayed());
        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
    }
}
