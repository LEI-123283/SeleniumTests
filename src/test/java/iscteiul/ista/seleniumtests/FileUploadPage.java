package iscteiul.ista.seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {
    private WebDriver driver;
    public static final String URL = "http://the-internet.herokuapp.com/upload";

    @FindBy(id = "file-upload")
    private WebElement fileUploadInput;

    @FindBy(id = "file-submit")
    private WebElement fileSubmitButton;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFilesText;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToFileUploadPage() {
        driver.get(URL);
    }

    public void uploadFile(String filePath) {
        fileUploadInput.sendKeys(filePath);
    }

    public void submitFile() {
        fileSubmitButton.click();
    }

    public String getUploadedFileName() {
        return uploadedFilesText.getText();
    }
}