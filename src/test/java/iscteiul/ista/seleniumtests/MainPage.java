package iscteiul.ista.seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

// page_url = https://www.jetbrains.com/
public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(), 'Accept') or contains(text(), 'Accept All')]")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "//*[@data-test-marker='Developer Tools']")
    public WebElement seeDeveloperToolsButton;

    @FindBy(xpath = "//*[@data-test='suggestion-action']")
    public WebElement findYourToolsButton;

    @FindBy(xpath = "//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']")
    public WebElement toolsMenu;

    @FindBy(css = "[data-test='site-header-search-action']")
    public WebElement searchButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
            wait.until(ExpectedConditions.invisibilityOf(acceptCookiesButton));

            System.out.println("Banner de cookies aceite e removido com sucesso.");

        } catch (Exception e) {
            System.out.println("Erro ao interagir com o banner de cookies: " + e.getMessage());
        }
    }
}