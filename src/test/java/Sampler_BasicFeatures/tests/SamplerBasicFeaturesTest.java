package Sampler_BasicFeatures.tests;

import Sampler_BasicFeatures.pages.SamplerBasicFeaturesPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

@ExtendWith(AllureJunit5.class)   // ⭐ OBRIGATÓRIO PARA GERAR allure-results
public class SamplerBasicFeaturesTest {

    @BeforeAll
    public static void setUp() {

        // ⭐ Listener do Selenide → envia screenshots, steps e anexos para o Allure
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));

        // Configurações do browser
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    public void testSamplerIconInteraction() {
        // 1. Abrir a página
        open("https://demo.vaadin.com/sampler/#ui/basic-features");

        // 2. Page Object
        SamplerBasicFeaturesPage samplerPage = new SamplerBasicFeaturesPage();

        // 3. Navegar até "Basic Features > Icon"
        samplerPage.navigateToIconSection();

        sleep(1000);

        // 4. Preencher o formulário
        samplerPage.fillIconForm("Teste de Aceitação Selenide", "25-11-2024");

        sleep(2000);
    }
}
