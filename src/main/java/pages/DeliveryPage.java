package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeliveryPage {
        WebDriver driver;

        // data customer
        String firstName    = "Jefri";
        String lastName     = "Testing";
        String email        = "jefri@testing.com";
        String phone        = "87560070022";
        String address      = "Jl. Raya Cilandak Barat No. 17";
        String addressNotes = "Apartemen Cilandak tower 21";

        // locator form customer
        By input_firstName    = By.id("name_DELIVERY");
        By input_lastName     = By.id("lastname_DELIVERY");
        By input_email        = By.id("email_DELIVERY");
        By input_repeatEmail  = By.id("emailrep_DELIVERY");
        By input_phone        = By.id("phone_DELIVERY");

        // locator form address
        By input_address      = By.id("guestAddress_DELIVERY");
        By input_addressNotes = By.id("guestAdditional_address_DELIVERY");

        
        // locator form delivery
        // form building type
        By form_buildingType = By.xpath("//*[@id='stepdelivery']/div[2]/div[2]/div[20]/div/div/form");

        // search bulding type
        By searchBuilding   = By.xpath("//input[contains(@class, 'select2-search__field')]");

        // selected building
        By selectedBuilding = By.xpath("//ul[@id='select2-building_type_DELIVERY-results']//li[contains(text(), 'Apartemen')] ");
        
        
        // locator delivery schedule
        By datePicker       = By.id("datepicker-container_DELIVERY");
        By dateArrival      = By.xpath("//*[@id='datepicker-container_DELIVERY']/div/div[3]/ul[3]/li[29]"); 
        By timeDelivery     = By.xpath("//*[@id='timeslot_wrapper_DELIVERY']/div");
        By continueCheckout = By.id("button_continue_checkout");
        
        // locator payment
        By paymentMethod    = By.xpath("//*[@id='stepreview']/div/div[2]/div[6]/div[1]/div[4]/div");
        By acceptTerms      = By.xpath("//*[@id='stepreview']/div/div[2]/div[7]/div/div/span");
        By button_continuePay = By.id("btnreview");
    


        public DeliveryPage(WebDriver driver) {
            this.driver = driver;
        }


        public void processDelivery() throws InterruptedException {
            // wait until form delivery is visible
            WebElement form_firstName = new WebDriverWait(driver, Duration.ofSeconds(10))
                      .until(ExpectedConditions.visibilityOfElementLocated(input_firstName));

            // input first name
            form_firstName.sendKeys(this.firstName);

            // input last name
            driver.findElement(input_lastName).sendKeys(this.lastName);
           
            
            // scroll the page to make sure form email is visible
            WebElement form_email = driver.findElement(input_email);
            
            ((JavascriptExecutor) driver).executeScript(
                "const rect = arguments[0].getBoundingClientRect();" +
                "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
                form_email
            );

            Thread.sleep(2000);


            // input email
            form_email.sendKeys(this.email);

            // repeat input email
            driver.findElement(input_repeatEmail).sendKeys(this.email);

            // input phone
            driver.findElement(input_phone).sendKeys(this.phone);

            // continue entry address info
            entryAddress();
        }



        public void entryAddress() throws InterruptedException {            
            // scroll the page to make sure form address notes is visible
            WebElement form_addressNotes = driver.findElement(input_addressNotes);

            ((JavascriptExecutor) driver).executeScript(
                "const rect = arguments[0].getBoundingClientRect();" +
                "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
                form_addressNotes
            );

            Thread.sleep(2000);

            // input address
            driver.findElement(input_address).sendKeys(this.address);

            // input address notes
            driver.findElement(input_addressNotes).sendKeys(this.addressNotes);

            // click dropdown building type
            driver.findElement(form_buildingType).click();
            
            // input keyword building type
            driver.findElement(searchBuilding).sendKeys("a");

            // click selected building
            driver.findElement(selectedBuilding).click();

            // continue entry schedule
            entrySchedule();
        }



        public void entrySchedule() throws InterruptedException {
            // scroll the page to make sure datepicker is visible
            WebElement element_datePicker = driver.findElement(datePicker);
            
            ((JavascriptExecutor) driver).executeScript(
                "const rect = arguments[0].getBoundingClientRect();" +
                "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
                element_datePicker
            );

            Thread.sleep(2000);

            
            // select date arrival
            driver.findElement(dateArrival).click();


            
            
            // scroll the page to make sure selector time delivery is visible
            WebElement element_timeDelivery = driver.findElement(timeDelivery);

            ((JavascriptExecutor) driver).executeScript(
                "const rect = arguments[0].getBoundingClientRect();" +
                "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
                element_timeDelivery
            );

            Thread.sleep(2000);

            // select time delivery
            element_timeDelivery.click();




            // scroll the page to make sure button checkout is visible
            WebElement element_continueCheckout = driver.findElement(continueCheckout);

            ((JavascriptExecutor) driver).executeScript(
                "const rect = arguments[0].getBoundingClientRect();" +
                "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
                    element_continueCheckout
            );

            Thread.sleep(2000);

            // click button continue checkout
            element_continueCheckout.click();

            // confirm order
            confirmOrder();
        }



        public void confirmOrder() throws InterruptedException {
            // assert order information

            
            // wait until form payment method is visible
            WebElement form_paymentMethod = new WebDriverWait(driver, Duration.ofSeconds(10))
                      .until(ExpectedConditions.visibilityOfElementLocated(paymentMethod));


            // scroll the page to make sure form payment method is visible
            ((JavascriptExecutor) driver).executeScript(
                "const rect = arguments[0].getBoundingClientRect();" +
                "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
                    form_paymentMethod
            );

            Thread.sleep(2000);

            // click button payment method 
            form_paymentMethod.click();




            // wait until form payment method is visible
            WebElement checkbox_acceptTerms = new WebDriverWait(driver, Duration.ofSeconds(10))
                      .until(ExpectedConditions.visibilityOfElementLocated(acceptTerms));

             // scroll the page to make sure checkbox accept terms is visible
            ((JavascriptExecutor) driver).executeScript(
                "const rect = arguments[0].getBoundingClientRect();" +
                "window.scrollBy({ top: rect.top - (window.innerHeight / 2), behavior: 'auto' });",
                    checkbox_acceptTerms
            );

            Thread.sleep(2000);


            // click checkbox accept terms
            checkbox_acceptTerms.click();


            // click button continue pay
            driver.findElement(button_continuePay).click();
        }

       
}
