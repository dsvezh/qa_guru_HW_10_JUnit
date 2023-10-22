import base.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MegafonLoginPage;


import static com.codeborne.selenide.Selenide.open;

public class MegafonLoginTest extends TestBase {

    MegafonLoginPage megafonLoginPage = new MegafonLoginPage();

    @BeforeEach
    void setup() {
        open("/");
    }


    @Tags({@Tag("UI"), @Tag("Valid"), @Tag("Smoke")})
    @ValueSource(strings = {"9210000000", "9270000000", "9990000000"})
    @DisplayName("Поле ввода номера телефона допускает введённый номер")
    @ParameterizedTest(name = " телефон = {0}")
    void phoneFieldShouldAcceptGivenPhoneNumber(String phoneNumber) {

        megafonLoginPage.fillPhoneNumberField(phoneNumber)
                        .checkValidFormFormat();
    }

    @Tags({@Tag("UI"), @Tag("Invalid"), @Tag("Smoke")})
    @ValueSource(strings = {"7777777777", "0987654321", "1234567890"})
    @DisplayName("Поле ввода номера телефона не допускает введённый номер")
    @ParameterizedTest(name = "{index} телефон = {0}")
    void phoneFieldShouldNotAcceptGivenPhoneNumber(String phoneNumber) {

        megafonLoginPage.fillPhoneNumberField(phoneNumber)
                        .checkErrorFormFormat();
    }

}
