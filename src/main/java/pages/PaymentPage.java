package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
    WebDriver driver;

    // locator payment
    By option_bankTransfer  = By.id("bank_transfer");        
    By modalPayment         = By.xpath("//div[@class='payment-container-list']");
    By bankOption           = By.xpath("//a[@class='bank-list' and @href='#/bank-transfer/mandiri-va']");
    By buttonClose          = By.cssSelector(".close-snap-button");
    By textThankYou         = By.xpath("//*[contains(text(), 'Terima kasih telah berbelanja di IKEA!')]");

      
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }


    public void makePayment() throws InterruptedException {
        // Switch to iframe by ID
        driver.switchTo().frame("snap-midtrans");

        // wait until option bank transfer is visible
        WebElement button_bankTransfer = new WebDriverWait(driver, Duration.ofSeconds(20))
                   .until(ExpectedConditions.visibilityOfElementLocated(option_bankTransfer));

        Thread.sleep(2000);

        // click option bank transfer
        button_bankTransfer.click();

    

        // Find the scrollable modal body
        WebElement modalBody = driver.findElement(modalPayment);
           
        // Scroll target into view within the modal
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollTop = arguments[1].offsetTop;", 
            modalBody, button_bankTransfer
        );


        // select bank
        WebElement selectedBank = driver.findElement(bankOption);
        selectedBank.click();
            
        Thread.sleep(2000);


        // close payment modal
        WebElement closeModal = driver.findElement(buttonClose);
        closeModal.click();

        // Switch back to main content
        driver.switchTo().defaultContent();  
    }


    public boolean getConfirmationMessage() {
        // check purchase status
        // Find the element containing the text Thank You
        WebElement thankYouElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                   .until(ExpectedConditions.visibilityOfElementLocated(textThankYou));

         
        // Assert Thank You element is displayed
        Boolean purchaseStatus = thankYouElement.isDisplayed();
        System.out.println(purchaseStatus);

        return purchaseStatus;    
    }

}
