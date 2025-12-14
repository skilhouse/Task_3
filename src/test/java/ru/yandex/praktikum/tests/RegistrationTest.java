package ru.yandex.praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.BaseTest;
import ru.yandex.praktikum.pages.LoginPage;
import ru.yandex.praktikum.pages.MainPage;
import ru.yandex.praktikum.pages.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация нового пользователя")
    public void successfulRegistrationTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();

        loginPage.clickRegisterLink();

        String email = "newuser" + System.currentTimeMillis() + "@example.com";
        registrationPage.fillRegistrationForm("New User", email, "password123");
        registrationPage.clickRegisterButton();

        Thread.sleep(3000);
        assertTrue("После регистрации должен быть переход на страницу входа",
                driver.getCurrentUrl().contains("login"));
    }

    @Test
    @DisplayName("Ошибка при регистрации с некорректным паролем (менее 6 символов)")
    public void registrationWithShortPasswordErrorTest() {
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();

        loginPage.clickRegisterLink();

        String email = "user" + System.currentTimeMillis() + "@example.com";
        registrationPage.fillRegistrationForm("Test User", email, "12345");
        registrationPage.clickRegisterButton();

        assertTrue("Должна отображаться ошибка для короткого пароля",
                registrationPage.isPasswordErrorDisplayed());

        String errorText = registrationPage.getPasswordErrorText();
        assertTrue("Текст ошибки должен содержать информацию о минимальной длине пароля",
                errorText.contains("Некорректный пароль") || errorText.contains("6 символов"));
    }
}