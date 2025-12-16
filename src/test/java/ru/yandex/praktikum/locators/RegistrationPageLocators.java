package ru.yandex.praktikum.locators;

import org.openqa.selenium.By;

public class RegistrationPageLocators {
    public static final By NAME_FIELD = By.xpath(".//label[text()='Имя']/following-sibling::input");
    public static final By EMAIL_FIELD = By.xpath(".//label[text()='Email']/following-sibling::input");
    public static final By PASSWORD_FIELD = By.xpath(".//input[@type='password']");
    public static final By REGISTER_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    public static final By LOGIN_LINK = By.xpath(".//a[text()='Войти']");
    public static final By PASSWORD_ERROR = By.xpath(".//p[contains(@class, 'input__error')]");
}