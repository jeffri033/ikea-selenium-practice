package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class ProductPage {
    WebDriver driver;

    // locator
    By openCart_button = By.xpath("//*[contains(text(), 'Lanjut ke keranjang belanja')]");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(String product_name) {
        // locator selected product
        By searchResult = By.xpath("//div[contains(@class, 'itemInfo') and @name='" + product_name + "']");


        // wait until element is visible then find element of 'selected item'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectedItem = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));

        // get all children from selected item
        List<WebElement> children = selectedItem.findElements(By.xpath("./*"));

        // get product name
        WebElement product_Name = children.get(0);  // First child
        String productName = product_Name.getText();
        System.out.println("productName: " + productName);

        // get product description
        WebElement productDesc = children.get(2);  
        System.out.println("productDesc: " + productDesc.getText());

        // get product price
        WebElement productPrice = children.get(3);  
        System.out.println("productPrice: " + productPrice.getText());

        // get element button add to cart
        WebElement addToCart_button = children.get(4);


        // scroll the page so element 'button add to card' is exactly centered.
        ((JavascriptExecutor) driver).executeScript(
            "const rect = arguments[0].getBoundingClientRect();" +
            "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
            addToCart_button
        );


        // wait until element 'button add to card' is clickable
        wait.until(ExpectedConditions.elementToBeClickable(addToCart_button));


        // click button add to cart
        addToCart_button.click();


        // wait until button open cart is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(openCart_button));

        // click to open cart page
        driver.findElement(openCart_button).click();
    }
}