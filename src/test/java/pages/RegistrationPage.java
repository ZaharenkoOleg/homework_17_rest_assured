package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    @Step("Открываем форму регитсрации")
    public RegistrationPage openRegistrationForm() {
        open("/register");
        return this;
    }
    @Step("Выбираем пол")
    public RegistrationPage setGender(String value) {
        $(byText(value)).click();
        return this;
    }
    @Step("Вводим имя")
    public RegistrationPage setFirstName(String value) {
        $("#FirstName").setValue(value);
        return this;
    }
    @Step("Вводим фамилию")
    public RegistrationPage setUserLastName(String value) {
        $("#LastName").setValue(value);
        return this;
    }
    @Step("Вводим email")
    public RegistrationPage setUserEmail(String value) {
        $("#Email").setValue(value);
        return this;
    }
    @Step("Вводим пароль")
    public RegistrationPage setUserPassword(String value) {
        $("#Password").setValue(value);
        return this;
    }
    @Step("Подтверждаем пароль")
    public RegistrationPage setConfirmUserPassword(String value) {
        $("#ConfirmPassword").setValue(value);
        return this;
    }
    @Step("Нажимаем Submit")
    public RegistrationPage setUserRegister() {
        $("#register-button").click();
        return this;
    }
    @Step("Проверяем успешность регистрации")
    public void checkResult() {
        $(".result").shouldHave(text("Your registration completed"));

    }
}
