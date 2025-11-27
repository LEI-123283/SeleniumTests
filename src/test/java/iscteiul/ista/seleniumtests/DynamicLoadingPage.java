package iscteiul.ista.seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {

    @FindBy(css = "#start button")
    public WebElement startButton;

    @FindBy(id = "finish")
    public WebElement finishText;

    public DynamicLoadingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickStart() {
        startButton.click();
    }

    public String getLoadedText() {
        return finishText.getText();
    }
}
