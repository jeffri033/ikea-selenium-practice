package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // locator
    By searchBox        = By.id("header_searcher_desktop_input");
    By sortButton       = By.id("sort-dropdown-btn");
    By dropdownOption   = By.xpath("//button[contains(@class, 'dropdown-item') and contains(text(), 'Produk unggulan')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void searchProduct(String product) {
        // enter search keyword
        driver.findElement(searchBox).sendKeys(product + Keys.ENTER);

        // click button to sort product
        driver.findElement(sortButton).click();

        // select product criteria
        driver.findElement(dropdownOption).click();
    }
}