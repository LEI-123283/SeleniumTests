package iscteiul.ista.seleniumtests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DropdownTest {
    private WebDriver driver;
    private Dropdown dropdownPage;

    @BeforeEach
    public void setUp() {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.get("https://the-internet.herokuapp.com/dropdown");

       dropdownPage = new Dropdown(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCheckboxes() {
        dropdownPage.getSelect().selectByVisibleText("Option 1");
        assertEquals("Option 1", dropdownPage.getSelect().getFirstSelectedOption().getText()); //verifica se a opção selecionada é a "Option 1"
        dropdownPage.getSelect().selectByVisibleText("Option 2");
        assertEquals("Option 2", dropdownPage.getSelect().getFirstSelectedOption().getText()); //verifica se a opção selecionada é a "Option 1"

    }


}
