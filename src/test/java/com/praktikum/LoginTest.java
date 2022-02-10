package com.praktikum;

import com.pageobgects.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class LoginTest extends SetupTest {
    UserOperations userOperations;
    MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    AccountPage accountPage = page(AccountPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    PasswordRecoverPage passwordRecoverPage = page(PasswordRecoverPage.class);

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @Test
    @DisplayName("Проверка входа по кнопке Войти в аккаунт на главной странице")
    public void loginFromMainpageEntryButton() {
        Map<String, String> testData = userOperations.register();
        mainPage.clickEntryAccountButton();
        loginPage.fillLoginForm(testData.get("email"), testData.get("password"));
        loginPage.checkEntryButton();
        assertTrue(mainPage.makeOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка входа через кнопку Личный кабинет")
    public void loginFromMainpagePersonalAccountButton() {
        Map<String, String> testData = userOperations.register();
        mainPage.clickPersonalAccountButton();
        loginPage.fillLoginForm(testData.get("email"), testData.get("password"));
        loginPage.checkEntryButton();
        assertTrue(mainPage.makeOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void loginFromRegistrationPage() {
        Map<String, String> testData = userOperations.register();
        mainPage.clickPersonalAccountButton();
        loginPage.clickLoginButton();
        registrationPage.clickLoginButton();
        loginPage.fillLoginForm(testData.get("email"), testData.get("password"));
        loginPage.checkEntryButton();
        assertTrue(mainPage.makeOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void loginFromPasswordRecoverPage() {
        Map<String, String> testData = userOperations.register();
        mainPage.clickPersonalAccountButton();
        loginPage.clickRecoverButton();
        passwordRecoverPage.clickEntryButton();
        loginPage.fillLoginForm(testData.get("email"), testData.get("password"));
        loginPage.checkEntryButton();
        assertTrue(mainPage.makeOrderButtonVisible());
    }

    @After
    public void deleteUser() {
        userOperations.delete();
        webdriver().driver().close();
    }
}
