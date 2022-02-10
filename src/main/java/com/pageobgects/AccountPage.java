package com.pageobgects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class AccountPage {
    //локатор кнопки "выход"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Выход')]")
    private SelenideElement exitButton;
    //локатор кнопки "конструктор"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;
    //локатор логотипа
    @FindBy(how = How.XPATH, using = ".//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoButton;

    @Step("Метод нажатия на кнопку Выход")
    public MainPage clickExitButton() {
        exitButton.click();
        return page(MainPage.class);
    }

    @Step("Метод нажатия на кнопку Конструктор")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }

    @Step("Метод нажатия по логотипу")
    public MainPage clickLogo() {
        logoButton.click();
        return page(MainPage.class);
    }

    @Step("Метод проверки наличия Выход")
    public boolean exitButtonVisible() {
        exitButton.shouldBe(visible, enabled);
        return true;
    }
}


