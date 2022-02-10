package com.pageobgects;

import com.codeborne.selenide.SelenideElement;
import com.pageobgects.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {
    //локатор поля "имя"
    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input")
    private SelenideElement nameField;
    //локатор поля "email"
    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement emailField;
    //локатор поля "пароль"
    @FindBy(how = How.XPATH, using = ".//fieldset[3]//input")
    private SelenideElement passwordField;
    //локатор кнопки "зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registrationButton;
    //локатор хелпер текста "некорректный пароль"
    @FindBy(how = How.XPATH, using = ".//*[@class='input__error text_type_main-default']")
    private SelenideElement errorPasswordText;
    //локатор кнопки "войти"
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement entryRegistrationButton;

    @Step("Метод нажатия на кнопку Зарегистрироваться")
    public void checkRegistrationButton() {
        registrationButton.click();
    }

    @Step("Метод нажатия на кнопку Войти")
    public LoginPage clickLoginButton() {
        entryRegistrationButton.click();
        return page(LoginPage.class);
    }

    @Step("Метод наличия хелпер текста Некорректный пароль")
    public boolean checkErrorText() {
        errorPasswordText.shouldBe(visible);
        return true;
    }

    @Step("Метод заполнения формы регистрации")
    public void fillRegistrationForm(String name, String email, String password) {
        nameField.setValue(name);
        emailField.setValue(email);
        passwordField.setValue(password);
    }
}
