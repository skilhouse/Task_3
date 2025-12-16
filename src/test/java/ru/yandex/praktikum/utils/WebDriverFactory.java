package ru.yandex.praktikum.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.InputStream;
import java.util.Properties;

public class WebDriverFactory {

    private static final Properties config = loadConfig();

    private static Properties loadConfig() {
        Properties props = new Properties();
        try (InputStream input = WebDriverFactory.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input != null) {
                props.load(input);
            }
        } catch (Exception e) {
            System.out.println("Конфиг не загружен, используем значения по умолчанию");
        }
        return props;
    }

    public static WebDriver getDriver() {
        String browser = System.getProperty("browser",
                config.getProperty("browser.default", "chrome"));

        System.out.println("Браузер: " + browser);

        return "yandex".equalsIgnoreCase(browser) ? getYandexDriver() : getChromeDriver();
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    private static WebDriver getYandexDriver() {
        String driverPath = config.getProperty("yandex.driver.path", "");
        if (!driverPath.isEmpty()) {
            System.setProperty("webdriver.chrome.driver", driverPath);
        } else {
            WebDriverManager.chromedriver().setup();
        }

        ChromeOptions options = new ChromeOptions();
        String browserPath = config.getProperty("yandex.browser.path", "");

        if (!browserPath.isEmpty()) {
            options.setBinary(browserPath);
            System.out.println("Яндекс.Браузер: " + browserPath);
        }

        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}