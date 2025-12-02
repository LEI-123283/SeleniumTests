package sampler_datainput.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;

public class SamplerDataInputPage {

    private final SelenideElement textFieldMenuOption = $(byText("Text field"));

    private final SelenideElement demoInput = $("input[placeholder='Write something']");

    public void openPage() {
        open("https://demo.vaadin.com/sampler/");
    }

    public void navigateToTextField() {
        textFieldMenuOption.shouldBe(visible).click();
    }

    public void setInputText(String text) {
        demoInput.shouldBe(visible).setValue(text);
    }

    public SelenideElement getInputField() {
        return demoInput;
    }
}