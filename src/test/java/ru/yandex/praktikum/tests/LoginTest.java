package ru.yandex.praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.BaseTest;
import ru.yandex.praktikum.pages.*;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход через кнопку 'Войти в аккаунт' на главной странице")
    public void loginFromMainPageButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();

        loginPage.login(testUser.getEmail(), testUser.getPassword());

        assertTrue("После входа должна отображаться кнопка 'Оформить заказ'",
                personalAccountPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void loginFromPersonalAccountButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.open();
        mainPage.clickPersonalAccountButton();

        loginPage.login(testUser.getEmail(), testUser.getPassword());

        assertTrue("После входа должна отображаться кнопка 'Оформить заказ'",
                personalAccountPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistrationFormTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();

        loginPage.clickRegisterLink();
        registrationPage.clickLoginLink();

        loginPage.login(testUser.getEmail(), testUser.getPassword());

        assertTrue("После входа должна отображаться кнопка 'Оформить заказ'",
                personalAccountPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromPasswordRecoveryFormTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();

        loginPage.clickRecoverPasswordLink();
        passwordRecoveryPage.clickLoginLink();

        loginPage.login(testUser.getEmail(), testUser.getPassword());

        assertTrue("После входа должна отображаться кнопка 'Оформить заказ'",
                personalAccountPage.isOrderButtonDisplayed());
    }
}