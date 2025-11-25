package iscteiul.ista.seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

    @FindBy(css = "#dropdown")
    public WebElement dropdownElement;

    public Dropdown(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Select getSelect() {
        return new Select(dropdownElement);
    }
}
