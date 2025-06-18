package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.BaseTest;
import org.testng.Assert;


public class ShopSteps extends BaseTest {
    WebDriver driver;
    HomePage home;
    ProductPage product;
    CartPage cart;
    DeliveryPage delivery;
    PaymentPage payment;


    @Given("I open the IKEA e-commerce website")
    public void i_open_the_IKEA_ecommerce_website() {
        driver = getDriver();
        driver.get("https://www.ikea.co.id/");
    }


    @When("I search for {string}")
    public void i_search_for_product(String product) {
        home = new HomePage(driver);
        home.searchProduct(product);
    }


    @And("I add the product {string} to cart")
    public void i_add_the_product_to_cart(String product_name) {
        product = new ProductPage(driver);
        product.addToCart(product_name);
    }


    @And("I proceed to checkout")
    public void i_proceed_to_checkout() throws InterruptedException {
        cart = new CartPage(driver);
        cart.goToCheckout();
    }

    
    @And("I fill in form delivery")
    public void i_fill_in_form_delivery() throws InterruptedException {
        delivery = new DeliveryPage(driver);
        delivery.processDelivery();
    }


    @And("I select payment method")
    public void i_select_payment_method() throws InterruptedException {
        payment = new PaymentPage(driver);
        payment.makePayment();
    }


    @Then("A confirmation message should be displayed")
    public void a_confirmation_message_should_be_displayed() {
        Boolean is_confirmation_message_displayed = payment.getConfirmationMessage();
        Assert.assertTrue(is_confirmation_message_displayed, "Confirmation message is not visible");

        // close browser
        if (driver != null) {
            driver.quit();
        }

        else {
            System.out.println("driver null");
        }
    }
}
