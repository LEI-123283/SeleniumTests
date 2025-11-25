package iscteiul.ista.seleniumtests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckboxesTest {
    private WebDriver driver;
    private Checkboxes checkboxesPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        checkboxesPage = new Checkboxes(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCheckboxes() {
        //começa com a checkbox 1 desmarcada e a checkbox 2 marcada
        assertFalse(checkboxesPage.checkbox1.isSelected(), "Checkbox 1 devia estar desmarcada");
        assertTrue(checkboxesPage.checkbox2.isSelected(), "Checkbox 2 devia estar marcada");
        //clica na checkbox 1 para marcar
        checkboxesPage.checkbox1.click();
        assertTrue(checkboxesPage.checkbox1.isSelected(), "Checkbox 1 devia estar marcada");
        //clica na checkbox 2 para desmarcar
        checkboxesPage.checkbox2.click();
        assertFalse(checkboxesPage.checkbox2.isSelected(), "Checkbox 2 devia estar desmarcada");

        assertTrue(checkboxesPage.checkbox1.isSelected(), "Checkbox 1 devia estar marcada");
        assertFalse(checkboxesPage.checkbox2.isSelected(), "Checkbox 2 devia estar desmarcada");
    }
}
