package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class OrderPage {
    WebDriver driver;

    // locator
    By searchZone       = By.id("search_zone_search-locality-process-order_typeahead");
    By selectedZone     = By.xpath("//*[@id='processOrder']/div[2]/div/div/div[2]/ul/li[1]");
    By homeDelivery     = By.xpath("//*[@id='processOrder']/div[4]/div[1]/div");
    
    By orderSummary     = By.xpath("//*[@id='summaryCard']/div[1]/div[4]/div[1]");
    By checkoutButton   = By.xpath("//*[@id='cart']/div[10]/div/div[3]");
    By guestCheckout    = By.xpath("//*[@id='login_guestCheckout']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public void processOrder() throws InterruptedException {
        // scroll the page to make sure element 'search zone' is visible
        WebElement element_searchZone = driver.findElement(searchZone);

        ((JavascriptExecutor) driver).executeScript(
            "const rect = arguments[0].getBoundingClientRect();" +
            "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
            element_searchZone
        );
        
        Thread.sleep(2000);



        // enter zone keyword
        element_searchZone.sendKeys("cilandak barat");

        // wait until element dropdown list zone is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement listZone = wait.until(ExpectedConditions.visibilityOfElementLocated(selectedZone));

        // select zone
        listZone.click();


        // select delivery option
        selectDelivery();
    }


    public void selectDelivery()  throws InterruptedException {
        // scroll the page to make sure button 'home delivery' is visible
        WebElement button_homeDelivery = driver.findElement(homeDelivery);

        ((JavascriptExecutor) driver).executeScript(
            "const rect = arguments[0].getBoundingClientRect();" +
            "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
            button_homeDelivery
        );

        Thread.sleep(2000);


        // click button option 'home delivery'
        button_homeDelivery.click();

        // process to payment
        continuePayment();   
    }


    public void continuePayment()  throws InterruptedException {
        // scroll the page to make sure element 'order summary' is visible
        WebElement element_orderSummary = driver.findElement(orderSummary);

        ((JavascriptExecutor) driver).executeScript(
            "const rect = arguments[0].getBoundingClientRect();" +
            "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
            element_orderSummary
        );

        Thread.sleep(2000);
  

        // click checkout button
        driver.findElement(checkoutButton).click();

        // process guest payment
        guestPayment();
    }


    public void guestPayment()  throws InterruptedException {
        // wait until button 'guest checkout is visible
        WebElement button_guestCheckout = new WebDriverWait(driver, Duration.ofSeconds(10))
                  .until(ExpectedConditions.visibilityOfElementLocated(guestCheckout));


        // scroll the page to make sure button 'guest checkout' is visible
        ((JavascriptExecutor) driver).executeScript(
            "const rect = arguments[0].getBoundingClientRect();" +
            "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
            button_guestCheckout
        );

        Thread.sleep(2000);


        // click button 'guest checkout'
        button_guestCheckout.click();
    }

}
