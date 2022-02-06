package com.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;

public class ConstructorTest extends SetupTest{
    MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
    @Test
    @DisplayName("Проверка переходов по разделам конструктора")
    public void checkConstructorTabsWorks(){
        mainPage.checkConstructorTabsWork();
        String actualBunText = mainPage.getTextBunTab().getText();
        String BunText = "Булки";
        String actualSauseText = mainPage.getTextSauseTab().getText();
        String SauseText = "Соусы";
        String actualFillingText = mainPage.getTextFillingsTab().getText();
        String FillingText = "Начинки";
        MatcherAssert.assertThat(actualBunText, containsString(BunText));
        MatcherAssert.assertThat(actualSauseText, containsString(SauseText));
        MatcherAssert.assertThat(actualFillingText, containsString(FillingText));
    }
}

