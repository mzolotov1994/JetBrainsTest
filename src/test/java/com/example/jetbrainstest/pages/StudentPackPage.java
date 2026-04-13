package com.example.jetbrainstest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// page_url = https://www.jetbrains.com/academy/student-pack/

public class StudentPackPage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href,\"buy?item=P:N:ALL:Y\")]")
    private WebElement buyButton;

    @FindBy(xpath = "//video[.//source[contains(@src,\"dev_tools.mp4\")]]")
    WebElement firstVideoInstruction;

    @FindBy(css = "svg._siteLogo__image_hu8cyn_1")
    WebElement mainLink;

    public boolean checkBuyButtonIsClickable() {
        System.out.println("Проверка активности кнопки купить");
        return buyButton.isEnabled();
    }

    public boolean checkFirstVideoInstructionIsVisible() {
        System.out.println("Проверка отображения первой видеоинструкции");
        return firstVideoInstruction.isDisplayed();
    }

    public void clickMainPageLink() {
        mainLink.click();
        System.out.println("Осуществили переход на главную страницу сайта");
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
