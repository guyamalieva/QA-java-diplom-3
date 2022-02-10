package com.pageobgects;

import com.codeborne.selenide.SelenideElement;
import com.pageobgects.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PasswordRecoverPage {
    //локатор кнопки "войти"
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement entryButton;

    @Step("Метод нажатия на Зарегистрироваться")
    public LoginPage clickEntryButton() {
        entryButton.click();
        return page(LoginPage.class);
    }
}
