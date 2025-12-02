// java
package Sampler_BasicFeatures.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SamplerBasicFeaturesPage {

    // --- Elementos de Navegação (Menu Lateral) ---
    private final SelenideElement basicFeaturesGroup = $(byText("Basic features"));
    private final SelenideElement iconMenuItem = $(byText("Icon"));

    // --- Elementos da Página "Icon" ---
    private final SelenideElement textField = $(byXpath("//*[contains(text(),'Text field')]/following::input[contains(@class, 'v-textfield')][1]"));
    private final SelenideElement dateFieldInput = $(byXpath("//span[text()='Date field']/following::input[contains(@class, 'v-datefield-textfield')][1]"));
    private final SelenideElement actionButton = $(byXpath("//div[contains(@class, 'v-button') and .//span[contains(text(), 'Button')]]"));    // --- Métodos de Interação ---

    // Navegar até à secção correta
    public void navigateToIconSection() {
        // Verifica se o item Icon já está visível para evitar fechar o menu acidentalmente
        if (!iconMenuItem.isDisplayed()) {
            if (basicFeaturesGroup.exists()) {
                basicFeaturesGroup.click();
            }
        }
        iconMenuItem.shouldBe(visible).click();
    }

    // Preencher o formulário conforme pedido: frase, data e botão
    public void fillIconForm(String phrase, String dateValue) {
        // 1. Escrever uma frase
        textField.shouldBe(visible).setValue(phrase);

        // 2. Selecionar uma data (escrevendo diretamente no input para maior estabilidade)
        // Formato comum: dd/MM/yy ou MM/dd/yy dependendo do locale do browser
        dateFieldInput.shouldBe(visible).setValue(dateValue).pressEnter();

        // 3. Carregar no botão
        actionButton.shouldBe(visible).click();
    }
}