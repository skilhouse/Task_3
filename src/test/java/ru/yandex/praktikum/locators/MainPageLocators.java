package ru.yandex.praktikum.locators;

import org.openqa.selenium.By;

public class MainPageLocators {
    public static final By CONSTRUCTOR_HEADER = By.xpath(".//h1[text()='Соберите бургер']");
    public static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By PERSONAL_ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    public static final By CONSTRUCTOR_BUTTON = By.xpath(".//p[text()='Конструктор']");
    public static final By LOGO = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    public static final By BUNS_SECTION = By.xpath(".//span[text()='Булки']/parent::div");
    public static final By SAUCES_SECTION = By.xpath(".//span[text()='Соусы']/parent::div");
    public static final By FILLINGS_SECTION = By.xpath(".//span[text()='Начинки']/parent::div");
    public static final By CURRENT_SECTION = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span");
}