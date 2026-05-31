package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// page_url = https://www.jetbrains.com/academy/student-pack/

public class StudentPackPage {

    //private final Logger LOG = LoggerFactory.getLogger(StudentPackPage.class);
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(StudentPackPage.class));

    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href,\"buy?item=P:N:ALL:Y\")]")
    private WebElement buyButton;

    @FindBy(xpath = "//video[.//source[contains(@src,\"dev_tools.mp4\")]]")
    WebElement firstVideoInstruction;

    @FindBy(css = "svg[class*='_siteLogo__image']")
    WebElement mainLink;

    @FindBy(xpath = "//button[.//span[text()='Learn more']]")
    WebElement learnMoreButton;

    @FindBy(xpath = "//a[text()='Developer Recognition']")
    WebElement developerRecognitionLink;

    @FindBy(xpath = "//footer//a[contains(@href,'instagram')]")
    WebElement instFutterLink;

    @FindBy(css = "svg[data-test='down-icon']")
    WebElement productsSelector;

    //Элементы для проверок FAQ
    @FindBy(xpath = "//span[text()='I didn’t find the answer to my question. What should I do?']")
    WebElement faqButton;

    @FindBy(xpath = "//*[contains(.,'No worries! You can find more details')]")
    WebElement faqText;

    //Элементы для проверок поля email
    @FindBy(css = "button[data-test='submit-button']")
    WebElement submitButton;

    @FindBy(xpath = "//span[contains(text(),'This field is required')]")
    WebElement emailRequiredMessage;

    //Элементы для проверок смены языка
    @FindBy(xpath = "//a[contains(@href,'student-pack')]//span[@data-test='button__content']")
    WebElement studentButton;

    @FindBy(xpath = "//header//button[@data-test='language-picker']")
    WebElement changeLanguageButton;

    @FindBy(xpath = "//span[@data-test='list-item' and .//span[text()='Русский']]")
    WebElement russianLanguageLink;

    //Элемент для проверки перехода по ссылке Discord
    @FindBy(xpath = "//a[contains(@href,'discord.com/invite/') and text()='Discord']")
    WebElement discordLink;

    //Элементы для проверки Поиска
    @FindBy(xpath = "//input[@data-test-id='search-input']")
    WebElement searchInput;

    @FindBy(css = "button[data-test='site-header-search-action']")
    WebElement searchIcon;

    @FindBy(css = "span[data-test=\"input__clear-icon\"]")
    WebElement clearIcon;

    @FindBy(xpath = "//button[@data-test='full-search-button']")
    WebElement fullSearchButton;

    //Элементы для проверки кнопки Больше в хедере
    @FindBy(xpath = "//button[@data-test='main-menu-more-button']")
    WebElement moreButton;

    @FindBy(xpath = "//div[@data-test='dropdown']")
    WebElement dropdownList;

    //Элементы для проверок кнопки региона в футтере
    @FindBy(xpath = "//button[@data-test='footer-country-button']")
    WebElement footerCountryButton;

    @FindBy(xpath = "//button[@data-test='footer-popup-confirm-country']")
    WebElement popupConfirmButton;

    @FindBy(xpath = "//div[@data-test='select' and .//input[@data-test='search-input']]")
    WebElement popupSearchCountryInput;

    //Элемент для проверки тогла обратной связи на RU локали
    @FindBy(css = "#hj-survey-toggle-1")
    WebElement feedbackToggle;


    public boolean checkBuyButtonIsClickable() {
        LOG.infoWithScreenshot("Проверка активности кнопки купить");
        return buyButton.isEnabled();
    }

    public boolean checkFirstVideoInstructionIsVisible() {
        LOG.infoWithScreenshot("Проверка отображения первой видеоинструкции");
        return firstVideoInstruction.isDisplayed();
    }

    public void clickMainPageLink() {
        mainLink.click();
        LOG.infoWithScreenshot("Осуществили переход на главную страницу сайта");
    }

    public boolean checkLearnMoreButtonIsClickable() {
        learnMoreButton.click();
        LOG.infoWithScreenshot("Проверка активности кнопки Learn More");
        return learnMoreButton.isEnabled();
    }

    public boolean checkDevRecognitionIsDisplayed() {
        LOG.infoWithScreenshot("Проверка отображения ссылки Developer Description");
        return developerRecognitionLink.isDisplayed();
    }

    public void clickDevRecognitionLink() {
        developerRecognitionLink.click();
        LOG.infoWithScreenshot("Осуществили переход на страницу Developer Recognition");
    }

    public void clickInstagramFutterLink() {
        instFutterLink.click();
    }

    public boolean checkProductsSelectorIsClickable() {
        productsSelector.click();
        LOG.infoWithScreenshot("Нажали на селектор с выбором продукта");
        return productsSelector.isEnabled();
    }

    //Методы для тестов раздела FAQ
    public boolean checkClickFaqButtonIsClickable() {
        faqButton.click();
        LOG.infoWithScreenshot("Нажали на кнопку в разделе FAQ");
        return faqButton.isEnabled();
    }

    public String getFaqText() {
        return faqText.getText();
    }

    //Методы для тестов поля email
    public boolean isEmailRequiredMessageDisplayed() {
        submitButton.click();
        LOG.infoWithScreenshot("Нажали на кнопку Submit с незаполненным email");
        return emailRequiredMessage.isDisplayed();
    }

    //Методы для смены языка
    public void changeLanguage() {
        changeLanguageButton.click();
        LOG.infoWithScreenshot("Нажали на кнопку смены языка");
        russianLanguageLink.click();
        LOG.infoWithScreenshot("Сменили язык на русский");
    }

    public String getStudentButtonText() {
        return studentButton.getText();
    }

    //Метод для перехода по ссылке Discord
    public void shouldRedirectToDiscordPage() {
        discordLink.click();
        LOG.infoWithScreenshot("Нажали на ссылку для перехода на сайт Discord");
        ArrayList tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) driver.switchTo().window(tabs.get(1).toString());
        LOG.infoWithScreenshot("Перешли в новую вкладку");
    }

    //Методы для проверки Поиска
    public boolean checkSearchInputIsDisplayed() {
        searchIcon.click();
        LOG.infoWithScreenshot("Нажали на иконку лупы в хэдере");
        return searchInput.isDisplayed();
    }

    public boolean checkClearIconIsClickable() {
        searchIcon.click();
        LOG.infoWithScreenshot("Нажали на иконку лупы в хэдере");
        String text = "text";
        searchInput.sendKeys(text);
        LOG.infoWithScreenshot("Вставили текст в инпут поиска");
        return clearIcon.isEnabled();
    }

    public void checkSearchInputAfterClearing() {
        searchIcon.click();
        LOG.infoWithScreenshot("Нажали на иконку лупы в хэдере");
        String text = "text";
        searchInput.sendKeys(text);
        LOG.infoWithScreenshot("Вставили текст в инпут поиска");
        clearIcon.click();
        LOG.infoWithScreenshot("Нажали на кнопку для очистки инпута поиска");
    }

    public boolean checkFullSearchButtonIsVisible() {
        searchIcon.click();
        LOG.infoWithScreenshot("Нажали на иконку лупы в хэдере");
        String text = "text";
        searchInput.sendKeys(text);
        LOG.infoWithScreenshot("Вставили текст в инпут поиска");
        return fullSearchButton.isDisplayed();
    }

    public String getSearchInputText() {
        return searchInput.getAttribute("value");
    }

    //Методы для проверки дропдауна в кнопке Больше при изменении разрешения экрана
    public boolean checkDropdownListIsDisplayed() {
        changeLanguageButton.click();
        LOG.infoWithScreenshot("Нажали на кнопку смены языка");
        russianLanguageLink.click();
        LOG.infoWithScreenshot("Сменили язык на русский");
        moreButton.click();
        LOG.infoWithScreenshot("Нажали на кнопку Больше в хедере");
        return dropdownList.isDisplayed();
    }

    //Методы для проверки кнопки с регионом, в футтере
    public boolean checkPopupConfirmButtonIsClickable() {
        footerCountryButton.click();
        LOG.infoWithScreenshot("Нажали на кнопку c выбором страны/региона");
        return popupConfirmButton.isEnabled();
    }

    public void countryIsNotAppliedWithoutConfirmation() {
        String countryName = "Austria";

        footerCountryButton.click();
        LOG.infoWithScreenshot("Нажали на кнопку c выбором страны/региона");

        popupSearchCountryInput.sendKeys(countryName);
        LOG.infoWithScreenshot("Ввели название страны");

        popupConfirmButton.click();
        LOG.infoWithScreenshot("Нажали на кнопку Подтвердить");
    }

    public String getFooterCountryButtonText() {
        return footerCountryButton.getText();
    }

    public void setOtherResolution() {
        driver.manage().window().setSize(new Dimension(1270, 677));
    }

    //Методы для проверки тогла обратной связи на RU локали
    public boolean checkFeedbackToggleIsVisible() {
        changeLanguageButton.click();
        LOG.infoWithScreenshot("Нажали на кнопку смены языка");
        russianLanguageLink.click();
        LOG.infoWithScreenshot("Сменили язык на русский");
        return feedbackToggle.isDisplayed();
    }

    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> cookiesAccept = driver.findElements(By.cssSelector("button.ch2-btn-primary"));

        if (!cookiesAccept.isEmpty()) {
            WebElement btn = cookiesAccept.get(0);
            wait.until(ExpectedConditions.elementToBeClickable(btn));
            btn.click();
        }
    }

    public StudentPackPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
