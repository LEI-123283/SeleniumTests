package iscteiul.ista.seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthentication {
    @FindBy(css = "#username")
    public WebElement usernameInput;

    @FindBy(css = "#password")
    public WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    @FindBy(css = ".flash.error")
    public WebElement errorMessage;

    @FindBy(css = ".flash.success")
    public WebElement successMessage;

    public FormAuthentication(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
