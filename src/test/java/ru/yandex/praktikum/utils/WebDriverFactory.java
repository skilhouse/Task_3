package ru.yandex.praktikum.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public static WebDriver getDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        System.out.println("Браузер: " + browser);

        if ("yandex".equals(browser)) {
            return getYandexDriver();
        } else {
            return getChromeDriver();
        }
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    private static WebDriver getYandexDriver() {
        String yandexDriverPath = "C:/Users/user/yandexdriver.exe";
        System.setProperty("webdriver.chrome.driver", yandexDriverPath);

        ChromeOptions options = new ChromeOptions();
        String yandexBrowserPath = "C:/Users/user/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";
        options.setBinary(yandexBrowserPath);

        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");

        return new ChromeDriver(options);
    }
}