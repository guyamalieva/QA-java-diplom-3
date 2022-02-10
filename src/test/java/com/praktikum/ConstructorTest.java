package com.praktikum;

import com.pageobgects.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ConstructorTest extends SetupTest {
    MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);

    @Test
    @DisplayName("Проверка переходов в раздел Булки")
    public void checkConstructorTabBunWorks() {
        mainPage.checkConstructorTabBunWork();
        assertTrue("Некорректное название таба", mainPage.getTextBunTab());
    }

    @Test
    @DisplayName("Проверка переходов в раздел Соусы")
    public void checkConstructorTabSauseWorks() {
        mainPage.checkConstructorTabSauseWork();
        assertTrue("Некорректное название таба", mainPage.getTextSauseTab());
    }

    @Test
    @DisplayName("Проверка переходов в раздел Начинки")
    public void checkConstructorTabFillingWorks() {
        mainPage.checkConstructorTabFillingWork();
        assertTrue("Некорректное название таба", mainPage.getTextFillingsTab());
    }
}

