package com.praktikum;
import com.codeborne.selenide.SelenideElement;
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

    //метод нажатия по кнопке "Выход"
    public MainPage clickExitButton() {
        exitButton.click();
        return page(MainPage.class);
    }
    //метод нажатия по кнопке "конструктор"
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }
    //метод нажатия по логотипу
    public MainPage clickLogo() {
        logoButton.click();
        return page(MainPage.class);
    }
    //метод проверки наличия кнопки "выход"
    public boolean exitButtonVisible() {
        exitButton.shouldBe(visible, enabled);
        return true;
    }
}


