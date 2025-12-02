package sampler_datainput;

import com.codeborne.selenide.Configuration;
import sampler_datainput.pages.SamplerDataInputPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.value;

public class SamplerDataInputTest {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
    }

    @Test
    void testDataInputInteraction() {
        SamplerDataInputPage page = new SamplerDataInputPage();

        page.openPage();
        page.navigateToTextField();

        String textoCurto = "Teste123";

        page.setInputText(textoCurto);

        page.getInputField().shouldHave(value(textoCurto));
    }
}