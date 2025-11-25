package iscteiul.ista.seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Checkboxes {
    @FindBy(css = "#checkboxes input:nth-of-type(1)")
    public WebElement checkbox1;

    @FindBy(css = "#checkboxes input:nth-of-type(2)")
    public WebElement checkbox2;

    public Checkboxes(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
