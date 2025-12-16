package ru.yandex.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.locators.PersonalAccountPageLocators;

import java.time.Duration;

public class PersonalAccountPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Нажать кнопку 'Выход'")
    public void clickLogoutButton() {
        driver.findElement(PersonalAccountPageLocators.LOGOUT_BUTTON).click();
    }

    @Step("Проверить, что отображается кнопка 'Оформить заказ'")
    public boolean isOrderButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PersonalAccountPageLocators.ORDER_BUTTON));
            return driver.findElement(PersonalAccountPageLocators.ORDER_BUTTON).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Выполнить вход и переход в личный кабинет")
    public void loginAndGoToAccount(String email, String password) {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.login(email, password);
        mainPage.clickPersonalAccountButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(PersonalAccountPageLocators.PROFILE_TAB));
    }
}