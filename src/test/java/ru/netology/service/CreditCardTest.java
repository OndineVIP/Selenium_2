
package ru.netology.service;

        import com.codeborne.selenide.SelenideElement;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import static com.codeborne.selenide.Condition.exactText;
        import static com.codeborne.selenide.Selenide.*;

public class CreditCardTest {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999/");
    }

    @Test
    void shouldSignCorrect() {

        SelenideElement form = $("[form]");
        form.$("[data-test-id=name] input").setValue("Саня Белый");
        form.$("[data-test-id=phone] input").setValue("+79101112222");
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}