package Sampler_DataPresentation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import Sampler_DataPresentation.pages.SamplerDataPresentationPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep; // Importação necessária

@ExtendWith(AllureJunit5.class)
public class SamplerDataPresentationTest {

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));

        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 15000;
    }

    @Test
    void testAudioComponentPresentation() {
        SamplerDataPresentationPage page = new SamplerDataPresentationPage();

        page.openPage();

        page.navigateToAudioSection();

        page.getAudioComponent()
                .as("Componente de Áudio")
                .should(exist)
                .shouldBe(visible);

        System.out.println("Aguardando 5 segundos para simular a reprodução do áudio...");
        sleep(5000); // 5000 ms = 5 segundos

    }
}