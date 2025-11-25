package iscteiul.ista.seleniumtests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputsTest {
    private WebDriver driver;
    private Inputs inputsPage;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/inputs");
        inputsPage = new Inputs(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testNumberInput() {
        inputsPage.numberInput.sendKeys("12345");
        String valorAtual = inputsPage.numberInput.getAttribute("value");
        assertEquals("12345", valorAtual, "O valor do input numérico está incorreto.");
    }

    @Test
    public void testNumberInputWithArrowKeys() {
        inputsPage.numberInput.sendKeys("5");
        inputsPage.numberInput.sendKeys("\uE013"); // seta para cima
        String valorAtual = inputsPage.numberInput.getAttribute("value");
        assertEquals("6", valorAtual, "O valor do input numérico após pressionar a seta para cima está incorreto.");

        inputsPage.numberInput.sendKeys("\uE015"); // seta para baixo
        valorAtual = inputsPage.numberInput.getAttribute("value");
        assertEquals("5", valorAtual, "O valor do input numérico após pressionar a seta para baixo está incorreto.");
    }

}
