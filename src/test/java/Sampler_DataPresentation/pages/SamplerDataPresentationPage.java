package Sampler_DataPresentation.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SamplerDataPresentationPage {

    private final SelenideElement dataPresentationGroup = $(byText("Data presentation"));

    private final SelenideElement audioMenuItem = $(byText("Audio"));

    private final SelenideElement audioComponent = $("audio");

    public void openPage() {
        open("https://demo.vaadin.com/sampler/");
    }

    public void navigateToAudioSection() {
        if (!audioMenuItem.isDisplayed()) {
            if (dataPresentationGroup.exists()) {
                dataPresentationGroup.click();
            }
        }

        audioMenuItem.shouldBe(visible).click();
    }

    public SelenideElement getAudioComponent() {
        return audioComponent;
    }
}