package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.StudentPackPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class StudentPackTest extends BaseTest {

    private StudentPackPage studentPackPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/academy/student-pack/");
        studentPackPage = new StudentPackPage(getDriver());
        studentPackPage.acceptCookies();
    }

    @Test
    @DisplayName("Проверка активности кнопки Купить")
    public void checkBuyButtonIsClickable() {
        assertTrue(studentPackPage.checkBuyButtonIsClickable(), "Кнопка Купить не активна");
    }

    @Test
    @DisplayName("Проверка отображения первой видеоинструкции")
    public void checkVideoInstructionIsVisible() {
        assertTrue(studentPackPage.checkFirstVideoInstructionIsVisible(), "Первая видеоинструкция недоступна");
    }

    @Test
    @DisplayName("Переход на главную страницу JetBrains")
    public void checkMainPageUrl() {
        studentPackPage.clickMainPageLink();
        String actualUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://www.jetbrains.com/";

        assertEquals(expectedUrl, actualUrl, "Переход на главную страницу не осуществлен");
    }
}
