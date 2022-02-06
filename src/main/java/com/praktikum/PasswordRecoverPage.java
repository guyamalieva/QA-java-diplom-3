package com.praktikum;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class PasswordRecoverPage {
    //локатор кнопки "войти"
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement entryButton;

    //метод нажатия на "зарегистрироваться"
    public LoginPage clickEntryButton() {
        entryButton.click();
        return page(LoginPage.class);
    }
}
