package ru.yandex.praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.BaseTest;
import ru.yandex.praktikum.pages.MainPage;
import ru.yandex.praktikum.pages.PersonalAccountPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Конструктор'")
    public void goFromPersonalAccountToConstructorTest() {
        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        personalAccountPage.loginAndGoToAccount(testUser.getEmail(), testUser.getPassword());

        mainPage.clickConstructorButton();

        assertTrue("Должен отображаться заголовок конструктора",
                mainPage.isConstructorHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    public void goFromPersonalAccountToConstructorViaLogoTest() {
        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        personalAccountPage.loginAndGoToAccount(testUser.getEmail(), testUser.getPassword());

        mainPage.clickLogo();

        assertTrue("Должен отображаться заголовок конструктора",
                mainPage.isConstructorHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы' в конструкторе")
    public void goToSaucesSectionTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Thread.sleep(1000);

        mainPage.clickSaucesSection();
        Thread.sleep(1000);

        assertEquals("Должен быть активен раздел 'Соусы'",
                "Соусы", mainPage.getCurrentSection());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки' в конструкторе")
    public void goToFillingsSectionTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Thread.sleep(1000);

        mainPage.clickFillingsSection();
        Thread.sleep(1000);

        assertEquals("Должен быть активен раздел 'Начинки'",
                "Начинки", mainPage.getCurrentSection());
    }

    @Test
    @DisplayName("Переход к разделу 'Булки' в конструкторе")
    public void goToBunsSectionTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Thread.sleep(1000);

        mainPage.clickFillingsSection();
        Thread.sleep(1000);
        mainPage.clickBunsSection();
        Thread.sleep(1000);

        assertEquals("Должен быть активен раздел 'Булки'",
                "Булки", mainPage.getCurrentSection());
    }
}