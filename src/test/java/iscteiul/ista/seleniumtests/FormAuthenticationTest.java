package iscteiul.ista.seleniumtests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormAuthenticationTest {
    private WebDriver driver;
    private FormAuthentication formAuthenticationPage;

    @BeforeEach
    public void setUp() {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.get("https://the-internet.herokuapp.com/login");

       formAuthenticationPage = new FormAuthentication(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testValidLogin() {
        formAuthenticationPage.usernameInput.sendKeys("tomsmith");
        formAuthenticationPage.passwordInput.sendKeys("SuperSecretPassword!");

        formAuthenticationPage.loginButton.click();
        String msg = formAuthenticationPage.successMessage.getText();
        assertTrue(msg.contains("You logged into a secure area"),
                "Erro: A mensagem apareceu, mas o texto está errado. Texto atual: " + msg);
    }

    @Test
    public void testInvalidLogin() {
        formAuthenticationPage.usernameInput.sendKeys("eu");
        formAuthenticationPage.passwordInput.sendKeys("pass");

        formAuthenticationPage.loginButton.click();
        String msg = formAuthenticationPage.errorMessage.getText();
        assertTrue(msg.contains("Your username is invalid"),
                "O texto do erro está incorreto. Texto atual: " + msg);
    }
}
