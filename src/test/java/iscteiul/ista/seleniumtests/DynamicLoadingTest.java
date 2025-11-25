package iscteiul.ista.seleniumtests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicLoadingTest {

    private WebDriver driver;
    private DynamicLoadingPage dynamicLoadingPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDynamicLoading() {
        dynamicLoadingPage.clickStart();
        String text = dynamicLoadingPage.getLoadedText();
        assertEquals("Hello World!", text);
    }
}
