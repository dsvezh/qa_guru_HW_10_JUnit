package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MegafonLoginPage {

    static final SelenideElement phoneNumberField = $("[data-testid='PhoneInput-input']"),
                                validFormFormat = $("div.login-form-otp-phone div.mfui-text-field_valid"),
                                errorFormFormat = $("div.login-form-otp-phone div.mfui-text-field_error");

    public MegafonLoginPage fillPhoneNumberField(String phoneNumber) {
        phoneNumberField.setValue(phoneNumber).pressTab();
        return this;
    }

    public MegafonLoginPage checkValidFormFormat() {
        validFormFormat.should(exist);
        return this;
    }

    public MegafonLoginPage checkErrorFormFormat() {
        errorFormFormat.should(exist);
        return this;
    }

    public MegafonLoginPage checkIncorrectValues(String value) {
        phoneNumberField.shouldNotHave(Condition.value(value));
        return this;
    }

}