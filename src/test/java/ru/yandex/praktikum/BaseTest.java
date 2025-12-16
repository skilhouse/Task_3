package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.client.UserClient;
import ru.yandex.praktikum.model.User;
import ru.yandex.praktikum.utils.WebDriverFactory;

public class BaseTest {

    protected WebDriver driver;
    protected UserClient userClient;
    protected User testUser;
    protected String accessToken;

    @Before
    @Step("Инициализация драйвера и создание тестового пользователя")
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        System.out.println("Запуск тестов в браузере: " + browser);

        driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();

        userClient = new UserClient();

        createTestUser();
    }

    @Step("Создание тестового пользователя через API")
    private void createTestUser() {
        String email = "testuser" + System.currentTimeMillis() + "@example.com";
        testUser = new User(email, "password123", "Test User");
        accessToken = userClient.createUser(testUser).extract().path("accessToken");
    }

    @After
    @Step("Закрытие драйвера и удаление тестового пользователя")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }
}