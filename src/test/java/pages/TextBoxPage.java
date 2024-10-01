package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Disabled;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private final SelenideElement userEmailLocator = $("#userEmail");
    private final SelenideElement submitButtonLocator = $("#submit");
    private final SelenideElement outputLocator = $("#output");


    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setEmail (String value)
    {
        userEmailLocator.setValue(value);
        return this;
    }

    public void pushSubmitButton()
    {
        submitButtonLocator.click();
    }
    public TextBoxPage checkResult(String value)
    {
        outputLocator.shouldHave(text(value));
        return this;
    }

}
