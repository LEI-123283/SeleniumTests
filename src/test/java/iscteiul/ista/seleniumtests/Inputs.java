package iscteiul.ista.seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Inputs {

    @FindBy(css = "input[type='number']")
    public WebElement numberInput;

    public Inputs(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
