package tests;

import data.InputField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("Тесты страницы TextBox")
public class TextBoxTests extends TestBase {
    private final TextBoxPage textBoxPage = new TextBoxPage();



    @ValueSource(strings = {"ivanov@ivan.ru", "pertov@petr.ru", "sidorov@sidr.ru"})
    @DisplayName("При вводе определенного емэйла, он должен отображаться в окне результата")
    @ParameterizedTest(name = "Проверка емэйла {0}")
    void checkEnteredEmailAppearsInResultWindow(String inputEmail) {
        textBoxPage.openPage()
                .setEmail(inputEmail)
                .pushSubmitButton();

        textBoxPage.checkResult(inputEmail);
    }

    @CsvFileSource(resources = "/test_data/checkEnteredValueAppearsInResultWindow.csv")
    @DisplayName("При вводе определенного значения, оно должно отображаться в соответствующем окне результата")
    @ParameterizedTest(name = "Проверка значения {1}")
    void checkEnteredValueAppearsInResultWindow(String inputLocator, String value, String resultFieldLocator) {
        textBoxPage.openPage();
        $(inputLocator).setValue(value);
        textBoxPage.pushSubmitButton();
        $(resultFieldLocator).shouldHave(text(value));
    }

    @EnumSource(InputField.class)
    @DisplayName("Вводим в определенное поле определенное значение, и проверяем что оно находится в своем поле")
    @ParameterizedTest
    void checkEnteredValueMatchesItsField(InputField inputField) {
        textBoxPage.openPage();
        $("#"+inputField).setValue(inputField.description);
        $("#"+inputField).shouldHave(value(inputField.description));
    }

}
