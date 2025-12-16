package ru.yandex.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.locators.MainPageLocators;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public void open() {
        driver.get("https://stellarburgers.education-services.ru/");
    }

    @Step("Нажать кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        driver.findElement(MainPageLocators.LOGIN_BUTTON).click();
    }

    @Step("Нажать кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        driver.findElement(MainPageLocators.PERSONAL_ACCOUNT_BUTTON).click();
    }

    @Step("Нажать кнопку 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(MainPageLocators.CONSTRUCTOR_BUTTON).click();
    }

    @Step("Нажать на логотип")
    public void clickLogo() {
        driver.findElement(MainPageLocators.LOGO).click();
    }

    @Step("Перейти в раздел 'Булки'")
    public void clickBunsSection() {
        driver.findElement(MainPageLocators.BUNS_SECTION).click();
    }

    @Step("Перейти в раздел 'Соусы'")
    public void clickSaucesSection() {
        driver.findElement(MainPageLocators.SAUCES_SECTION).click();
    }

    @Step("Проверить заголовок конструктора")
    public boolean isConstructorHeaderDisplayed() {
        return driver.findElement(MainPageLocators.CONSTRUCTOR_HEADER).isDisplayed();
    }

    @Step("Перейти в раздел 'Начинки'")
    public void clickFillingsSection() {
        driver.findElement(MainPageLocators.FILLINGS_SECTION).click();
    }

    @Step("Получить текущий активный раздел")
    public String getCurrentSection() {
        return driver.findElement(MainPageLocators.CURRENT_SECTION).getText();
    }
}