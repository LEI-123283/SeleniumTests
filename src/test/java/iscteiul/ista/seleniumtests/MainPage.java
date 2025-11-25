package iscteiul.ista.seleniumtests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Botão real de fechar/aceitar cookies do CH2:
    @FindBy(css = "button.ch2-allow-all-btn, button[mode='allow']")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "//*[@data-test-marker='Developer Tools']")
    public WebElement seeDeveloperToolsButton;

    @FindBy(xpath = "//*[@data-test='suggestion-link']")
    public WebElement findYourToolsButton;

    @FindBy(xpath = "//*[contains(text(), 'Developer Tools') and contains(@class, 'mainMenuItem')]")
    public WebElement toolsMenu;

    @FindBy(css = "[data-test='site-header-search-action']")
    public WebElement searchButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        try {
            wait.until(ExpectedConditions.visibilityOf(acceptCookiesButton));
            acceptCookiesButton.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.ch2-container")));
            System.out.println("Cookies aceites com sucesso.");
        } catch (Exception e) {
            System.out.println("Nenhum banner de cookies visível.");
        }
    }

    // Clique seguro que evita ElementClickInterceptedException
    public void safeClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
}
