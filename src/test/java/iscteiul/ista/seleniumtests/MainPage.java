package iscteiul.ista.seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//button[contains(text(), 'Accept All')]")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "//*[@data-test-marker='Developer Tools']")
    public WebElement seeDeveloperToolsButton;

    @FindBy(xpath = "//*[@data-test='suggestion-link']") // alteração
    public WebElement findYourToolsButton;

    @FindBy(xpath = "//*[contains(text(), 'Developer Tools') and contains(@class, 'mainMenuItem')]")
    public WebElement toolsMenu;

    @FindBy(css = "[data-test='site-header-search-action']")
    public WebElement searchButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        try {
            if (acceptCookiesButton.isDisplayed()) { //verifica se o botão está visível antes de clicar
                acceptCookiesButton.click();
                System.out.println("Cookies aceites com sucesso.");
            }
        } catch (Exception e) {
            System.out.println("O banner de cookies não apareceu ou já foi aceite.");
        }
    }
}

