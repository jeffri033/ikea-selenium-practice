package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(WebElement addToCart_button) {
        // scroll the page so element 'button add to card' is exactly centered.
        ((JavascriptExecutor) driver).executeScript(
            "const rect = arguments[0].getBoundingClientRect();" +
            "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
            addToCart_button
        );


        // wait until element 'button add to card' is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCart_button));


        // click button add to cart
        addToCart_button.click();
    }
}