package com.praktikum;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;

public class SetupTest {

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
    }
}
