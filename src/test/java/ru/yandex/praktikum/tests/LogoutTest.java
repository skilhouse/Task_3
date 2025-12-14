package ru.yandex.praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.BaseTest;
import ru.yandex.praktikum.pages.*;

import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    @Test
    @DisplayName("Выход из аккаунта через личный кабинет")
    public void logoutFromPersonalAccountTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.login(testUser.getEmail(), testUser.getPassword());

        assertTrue("Должна отображаться кнопка 'Оформить заказ' после входа",
                personalAccountPage.isOrderButtonDisplayed());

        mainPage.clickPersonalAccountButton();
        Thread.sleep(2000);

        personalAccountPage.clickLogoutButton();
        Thread.sleep(2000);

        assertTrue("После выхода должна отображаться страница входа",
                loginPage.isLoginPageDisplayed());
    }
}