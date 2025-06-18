package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        return new ChromeDriver();
    }
}
