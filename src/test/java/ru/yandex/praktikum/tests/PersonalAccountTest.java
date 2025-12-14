package ru.yandex.praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.BaseTest;
import ru.yandex.praktikum.pages.*;

import static org.junit.Assert.assertTrue;

public class PersonalAccountTest extends BaseTest {

    @Test
    @DisplayName("Переход в личный кабинет после авторизации")
    public void goToPersonalAccountAfterLoginTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.login(testUser.getEmail(), testUser.getPassword());
        Thread.sleep(1000);

        mainPage.clickPersonalAccountButton();
        Thread.sleep(1000);

        String currentUrl = driver.getCurrentUrl();
        assertTrue("Должен быть переход в личный кабинет. URL: " + currentUrl,
                currentUrl.contains("account"));

    }
}