package pages.components;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResponsive {

    public void checkResult(String key, String value) {
        $(".modal-body").$(byText(key)).parent().shouldHave(text(value));
    }

    public void negativeCheckResult(String key, String value) {
        $(".modal-body").$(byText(key)).parent().shouldNotHave(text(value));
    }
    public void checkResultTextBox( String key, String value) {
        $("#output").shouldHave(text(key + value));
    }
}

