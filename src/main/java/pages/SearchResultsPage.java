package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helpers.ProductInfo;
import java.time.Duration;
import java.util.List;

public class SearchResultsPage {
    WebDriver driver;

    // locator
    By searchResult = By.xpath("//div[contains(@class, 'itemInfo') and @name='RENBERGET']"); // VIHALS 

   
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductInfo selectFirstProduct() {
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
        WebElement addToCart_element = children.get(4);

        return new ProductInfo(productName, addToCart_element);
    }
}