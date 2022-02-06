package com.praktikum;
import com.codeborne.selenide.SelenideElement;
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

    //метод нажатия на "зарегистрироваться"
    public RegistrationPage clickLoginButton() {
        loginButton.click();
        return page(RegistrationPage.class);
    }
    //метод заполнения формы авторизации
    public void fillLoginForm(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
    }
    //метод нажатия на кнопку войти
    public void checkEntryButton() {
        entryButton.click();
    }
    //метод нажатия на кнопку восстановить
    public PasswordRecoverPage clickRecoverButton() {
        recoverButton.click();
        return page(PasswordRecoverPage.class);
    }
    //метод отображения кнопки "войти"
    public boolean entryButtonVisible() {
        entryButton.shouldBe(visible, enabled);
        return true;
    }
}

