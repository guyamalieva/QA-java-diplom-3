package com.pageobgects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    //локатор кнопки "зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Зарегистрироваться')]")
    private SelenideElement loginButton;
    @FindBy(how = How.XPATH, using = ".//*[@class='Auth_login__3hAey']")
    private SelenideElement loginPage;
    //локатор поля "email"
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailField;
    //локатор поля "пароль"
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordField;
    //локатор кнопки "войти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement entryButton;
    //локатор кнопки "восстановить пароль"
    @FindBy(how = How.XPATH, using = "//*[text()='Восстановить пароль']")
    private SelenideElement recoverButton;

    @Step("Метод нажатия на Зарегистрироваться")
    public RegistrationPage clickLoginButton() {
        loginButton.click();
        return page(RegistrationPage.class);
    }

    @Step("Метод заполнения формы авторизации")
    public void fillLoginForm(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
    }

    @Step("Метод нажатия на кнопку Войти")
    public void checkEntryButton() {
        entryButton.click();
    }

    @Step("Метод нажатия на кнопку Восстановить")
    public PasswordRecoverPage clickRecoverButton() {
        recoverButton.click();
        return page(PasswordRecoverPage.class);
    }

    @Step("Метод отображения кнопки Войти")
    public boolean entryButtonVisible() {
        entryButton.shouldBe(visible, enabled);
        return true;
    }
}

