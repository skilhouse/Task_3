package ru.yandex.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.locators.PasswordRecoveryPageLocators;

public class PasswordRecoveryPage {
    private final WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать ссылку 'Войти'")
    public void clickLoginLink() {
        driver.findElement(PasswordRecoveryPageLocators.LOGIN_LINK).click();
    }
}