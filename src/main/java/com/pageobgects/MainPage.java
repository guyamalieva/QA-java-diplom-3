package com.pageobgects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    public final static String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    //локатор кнопки "войти в аккуант"
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement entryAccountButton;
    //локатор кнопки "оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement makeOrderButton;
    //локатор кнопки "личный кабинет"
    @FindBy(how = How.XPATH, using = "//*[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;
    //локатор таба "начинки"
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']")
    private SelenideElement fillingTab;
    //локатор таба "соусы"
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']")
    private SelenideElement sauceTab;
    //локатор таба "булки"
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']")
    private SelenideElement bunTab;

    //метод нажатия на кнопку "войти в аккуант"
    public LoginPage clickEntryAccountButton() {
        entryAccountButton.click();
        return page(LoginPage.class);
    }

    @Step("Метод нажатия на кнопку Личный кабинет")
    public LoginPage clickPersonalAccountButton() {
        personalAccountButton.click();
        return page(LoginPage.class);
    }

    @Step("Метод переключения таба Булки")
    public void checkConstructorTabBunWork() {
        bunTab.click();
    }

    @Step("Метод переключения таба Соусы")
    public void checkConstructorTabSauseWork() {
        sauceTab.click();
    }

    @Step("Метод переключения таба Начинки")
    public void checkConstructorTabFillingWork() {
        fillingTab.click();
    }

    @Step("Метод нажатия на кнопку Оформить заказ")
    public MainPage checkМakeOrderButton() {
        makeOrderButton.click();
        return page(MainPage.class);
    }

    @Step("Метод отображения кнопки Оформить заказ")
    public boolean makeOrderButtonVisible() {
        makeOrderButton.shouldBe(visible, enabled);
        return true;
    }

    @Step("Метод получения текста таба Булки")
    public boolean getTextBunTab() {
        bunTab.shouldHave(exactText("Булки"));
        return true;
    }

    @Step("Метод получения текста таба Соусы")
    public boolean getTextSauseTab() {
        sauceTab.shouldHave(exactText("Соусы"));
        return true;
    }

    @Step("Метод получения текста таба Начинки")
    public boolean getTextFillingsTab() {
        fillingTab.shouldHave(exactText("Начинки"));
        return true;
    }
}

