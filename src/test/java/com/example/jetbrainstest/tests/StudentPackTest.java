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

    @Test
    @DisplayName("Проверка активности кнопки Learn more")
    public void checkLearnMoreButtonIsClickable() {
        assertTrue(studentPackPage.checkLearnMoreButtonIsClickable(), "Кнопка Learn more не активна");
    }

    @Test
    @DisplayName("Проверка отображения ссылки Developer Description")
    public void checkDevRecognitionIsDisplayed() {
        assertTrue(studentPackPage.checkDevRecognitionIsDisplayed(), "Ссылка Developer Recognition отсутствует");
    }

    @Test
    @DisplayName("Переход на страницу Developer Recognition")
    public void clickDevRecognitionLink() {
        studentPackPage.clickDevRecognitionLink();
        String actualUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://www.jetbrains.com/community/dev-recognition/";

        assertEquals(expectedUrl, actualUrl, "Переход на страницу Developer Recognition не осуществлен");
    }

    @Test
    @DisplayName("Переход на страницу Instagram jetbrains из ссылки в футтере")
    public void clickInstagramFutterLink() {
        studentPackPage.clickInstagramFutterLink();
        String actualUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://www.instagram.com/jetbrains/";

        assertEquals(expectedUrl, actualUrl, "Переход на страницу Instagram jetbrains не осуществлен");
    }

    @Test
    @DisplayName("Проверка активности селектора с продуктами в разделе Graduates")
    public void checkProductsSelectorIsClickable() {
        assertTrue(studentPackPage.checkProductsSelectorIsClickable(), "Селектор с выбором продуктов не доступен");
    }

    @Test
    @DisplayName("Проверка активности кнопки в разделе FAQ")
    public void checkClickFaqButtonIsClickable() {
        assertTrue(studentPackPage.checkClickFaqButtonIsClickable(), "Кнопка в разделе FAQ не активна");
    }

    @Test
    @DisplayName("Проверка наличия нужного текста после клика на модуль в FAQ")
    public void checkFaqTextInFaqButton() {
        studentPackPage.checkClickFaqButtonIsClickable();
        String faqText = studentPackPage.getFaqText();
        assertTrue(faqText.contains("No worries! You can find more details"), "В модуле нет нужного текста");
    }

    @Test
    @DisplayName("Проверка отображения подсказки, что поле email обязательно для заполнения")
    public void isEmailRequiredMessageDisplayed() {
        assertTrue(studentPackPage.isEmailRequiredMessageDisplayed(), "Подсказка, что поле email обязательно не отображается");
    }

    @Test
    @DisplayName("Проверка смены языка на RU на кнопке Студенты")
    public void checkLanguageSwitchWorks() {
        studentPackPage.changeLanguage();
        String textAfter = studentPackPage.getStudentButtonText();
        assertTrue(textAfter.contains("Студентам"));
    }

    @Test
    @DisplayName("Проверка перехода на страницу инвайта в кананал Jetbrains в Discord")
    public void shouldRedirectToDiscordPage() {
        studentPackPage.shouldRedirectToDiscordPage();
        String actualUrl = getDriver().getCurrentUrl();
        String expectedUrl = "https://discord.com/invite/jpsDuV37bW";

        assertEquals(expectedUrl, actualUrl, "Переход на страницу инвайта в кананал Jetbrains в Discord не осуществлен");
    }

    @Test
    @DisplayName("Проверка отображения инпута Поиск")
    public void checkFeedBackToggleIsClickable() {
        assertTrue(studentPackPage.checkSearchInputIsDisplayed(), "Инпут для поиска не отображается");
    }

    @Test
    @DisplayName("Проверка отображения инпута Поиск")
    public void checkClearIconIsClickable() {
        assertTrue(studentPackPage.checkClearIconIsClickable(), "Кнопка очистки инпута поиска не активна");
    }

    @Test
    @DisplayName("Проверка очистки инпута поиска")
    public void checkSearchInputAfterClearing() {
        studentPackPage.checkSearchInputAfterClearing();
        assertTrue(studentPackPage.getSearchInputText().isEmpty(), "Инпут поиска содержит значение");
    }

    @Test
    @DisplayName("Проверка отображения кнопки Расширенного поиска")
    public void checkFullSearchButtonIsVisible() {
        assertTrue(studentPackPage.checkFullSearchButtonIsVisible(), "Кнопка для расширенного поиска не отображается");
    }

    @Test
    @DisplayName("Проверка отображения дропдаун списка в кнопке Больше при изменении разрешения экрана")
    public void checkDropdownListIsDisplayed() {
        studentPackPage.setOtherResolution();
        assertTrue(studentPackPage.checkDropdownListIsDisplayed(), "Дропдаун список не отображается");
    }

    @Test
    @DisplayName("Проверка активности кнопки Выбрать в поп-апе с выбором страны/региона")
    public void checkPopupConfirmButtonIsClickable() {
        assertTrue(studentPackPage.checkPopupConfirmButtonIsClickable(), "Кнопка Выбрать в поп-апе выбора страны/региона не активна");
    }

    @Test
    @DisplayName("Проверка, что наименование страны в кнопке не изменилось без подтверждающего действия")
    public void countryIsNotAppliedWithoutConfirmation() {
        studentPackPage.countryIsNotAppliedWithoutConfirmation();
        String expectedButtonName = studentPackPage.getFooterCountryButtonText();
        String actualButtonName = studentPackPage.getFooterCountryButtonText();
        assertEquals(expectedButtonName, actualButtonName, "Наименование страны в кнопке изменилось");
    }

    @Test
    @DisplayName("Проверка отображения тогла обратной связи на RU локали")
    public void checkFeedbackToggleIsVisible() {
        assertTrue(studentPackPage.checkFeedbackToggleIsVisible(), "Тогл обратной связи не отображается на странице");
    }

}
