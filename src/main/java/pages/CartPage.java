package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;

    // locator
    By productName = By.xpath("//*[@id='cart']/div[3]/div[3]/div/div[2]/div/div/a/strong");
    By openCart_button = By.xpath("//*[contains(text(), 'Lanjut ke keranjang belanja')]");

    
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public void openCart() {
        // wait until button is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(openCart_button));

        // click to open cart page
        driver.findElement(openCart_button).click();
    }


    public String getProductName() {
        // wait until product name is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));

        // get product name
        String product_name = driver.findElement(productName).getText();

        return product_name;
    }
}