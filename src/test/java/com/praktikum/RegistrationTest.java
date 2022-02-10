package com.praktikum;

import com.pageobgects.LoginPage;
import com.pageobgects.MainPage;
import com.pageobgects.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends SetupTest {
    public static final String EMAIL_POSTFIX = "@mail.ru";
    String email = RandomStringUtils.randomAlphabetic(7) + EMAIL_POSTFIX;
    String password = RandomStringUtils.randomAlphabetic(7);
    String passwordIncorrect = RandomStringUtils.randomAlphabetic(5);
    String name = RandomStringUtils.randomAlphabetic(7);
    MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void checkRegistrationWithExtends() {
        mainPage.clickEntryAccountButton();
        loginPage.clickLoginButton();
        registrationPage.fillRegistrationForm(name, email, password);
        registrationPage.clickLoginButton();
        assertTrue(loginPage.entryButtonVisible());
    }

    @Test
    @DisplayName("Проверка регистрации с невалидным паролем")
    public void checkRegistrationWithInvalidPasswords() {
        mainPage.clickEntryAccountButton();
        loginPage.clickLoginButton();
        registrationPage.fillRegistrationForm(name, email, passwordIncorrect);
        registrationPage.clickLoginButton();
        assertTrue(registrationPage.checkErrorText());
    }
}



