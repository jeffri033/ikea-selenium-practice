package helpers;
import org.openqa.selenium.WebElement;

public class ProductInfo {
    private String name;
    private WebElement element;

    public ProductInfo(String name, WebElement element) {
        this.name = name;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public WebElement getWebElement() {
        return element;
    }
}
