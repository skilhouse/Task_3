package ru.yandex.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.locators.LoginPageLocators;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Выполнить вход с email: {email} и паролем: {password}")
    public void login(String email, String password) {
        driver.findElement(LoginPageLocators.EMAIL_FIELD).sendKeys(email);
        driver.findElement(LoginPageLocators.PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LoginPageLocators.LOGIN_BUTTON).click();
    }

    @Step("Нажать ссылку 'Зарегистрироваться'")
    public void clickRegisterLink() {
        driver.findElement(LoginPageLocators.REGISTER_LINK).click();
    }

    @Step("Нажать ссылку 'Восстановить пароль'")
    public void clickRecoverPasswordLink() {
        driver.findElement(LoginPageLocators.RESTORE_PASSWORD_LINK).click();
    }

    @Step("Проверить, что отображается страница входа")
    public boolean isLoginPageDisplayed() {
        return driver.findElement(LoginPageLocators.LOGIN_HEADER).isDisplayed();
    }
}