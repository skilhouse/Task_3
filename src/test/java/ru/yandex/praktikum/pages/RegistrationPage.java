package ru.yandex.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.locators.RegistrationPageLocators;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввести имя: {name}")
    public void enterName(String name) {
        driver.findElement(RegistrationPageLocators.NAME_FIELD).sendKeys(name);
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        driver.findElement(RegistrationPageLocators.EMAIL_FIELD).sendKeys(email);
    }

    @Step("Ввести пароль: {password}")
    public void enterPassword(String password) {
        driver.findElement(RegistrationPageLocators.PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Нажать кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        driver.findElement(RegistrationPageLocators.REGISTER_BUTTON).click();
    }

    @Step("Нажать ссылку 'Войти'")
    public void clickLoginLink() {
        driver.findElement(RegistrationPageLocators.LOGIN_LINK).click();
    }

    @Step("Заполнить форму регистрации")
    public void fillRegistrationForm(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
    }

    @Step("Получить текст ошибки пароля")
    public String getPasswordErrorText() {
        return driver.findElement(RegistrationPageLocators.PASSWORD_ERROR).getText();
    }

    @Step("Проверить отображение ошибки пароля")
    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(RegistrationPageLocators.PASSWORD_ERROR).isDisplayed();
    }
}