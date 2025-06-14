package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    // Shared WebDriver instance
    protected WebDriver driver;

    public void setup() {
        // Start the browser
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ikea.co.id/");
    }

    public void tearDown() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
        }
    }
}