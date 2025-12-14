package ru.yandex.praktikum.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By RESTORE_PASSWORD_LINK = By.xpath(".//a[text()='Восстановить пароль']");
    public static final By LOGIN_HEADER = By.xpath(".//h2[text()='Вход']");
    public static final By EMAIL_FIELD = By.xpath(".//input[@name='name']");
    public static final By PASSWORD_FIELD = By.xpath(".//input[@name='Пароль']");
    public static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    public static final By REGISTER_LINK = By.xpath(".//a[text()='Зарегистрироваться']");
}