package com.praktikum;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class AccountTest extends SetupTest {
    UserOperations userOperations;
    MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    AccountPage accountPage = page(AccountPage.class);
    @Before
    public void setUp() {
        userOperations = new UserOperations();
        Map<String, String> testData = userOperations.register();
        mainPage.clickEntryAccountButton();
        loginPage.fillLoginForm(testData.get("email"), testData.get("password"));
        loginPage.checkEntryButton();
    }
    @Test
    @DisplayName("Проверка перехода в Личный кабинет")
    public void checkEnterFromPersonalAccountButton() {
        mainPage.clickPersonalAccountButton();
        assertTrue(accountPage.exitButtonVisible());
    }
    @Test
    @DisplayName("Проверка перехода на главную страницу из Личного кабинета по кнопке Конструктор")
    public void checkEnterFromConstructorButton() {
        mainPage.clickPersonalAccountButton();
        accountPage.exitButtonVisible();
        accountPage.clickConstructorButton();
        assertTrue(mainPage.makeOrderButtonVisible());
    }
    @Test
    @DisplayName("Проверка перехода на главную страницу из Личного кабинета по логотипу")
    public void checkEnterFromMainLogo() {
        mainPage.clickPersonalAccountButton();
        accountPage.exitButtonVisible();
        accountPage.clickLogo();
        assertTrue(mainPage.makeOrderButtonVisible());
    }
    @Test
    @DisplayName("Проверка выхода из личного кабинета")
    public void checkExitFromAccount() {
        mainPage.clickPersonalAccountButton();
        accountPage.clickExitButton();
        assertTrue(loginPage.entryButtonVisible());
    }
    @After
    public void deleteUser() {
        userOperations.delete();
        webdriver().driver().close();
    }
}