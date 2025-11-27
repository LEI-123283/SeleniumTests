package iscteiul.ista.seleniumtests;

import iscteiul.ista.seleniumtests.FileUploadPage;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.time.Duration;

public class FileUploadPageTest {
    private WebDriver driver;
    private FileUploadPage fileUploadPage;
    private WebDriverWait wait;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.navigateToFileUploadPage();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSuccessfulFileUpload() {
        String fileName = "ficheirodeteste";

        String absolutePath = new File(System.getProperty("user.dir"), fileName).getAbsolutePath();

        System.out.println("A tentar carregar o ficheiro: " + absolutePath);

        fileUploadPage.uploadFile(absolutePath);

        fileUploadPage.submitFile();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));

        String uploadedText = fileUploadPage.getUploadedFileName();

        assertTrue(uploadedText.contains(fileName),
                "O nome do ficheiro carregado não coincide. Esperado: " + fileName + ", Obtido: " + uploadedText);

        WebElement successHeader = driver.findElement(By.tagName("h3"));
        assertEquals("File Uploaded!", successHeader.getText());
    }
}