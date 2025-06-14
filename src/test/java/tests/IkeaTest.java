package tests;
import base.BaseTest;
import helpers.ProductInfo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class IkeaTest extends BaseTest {
    @Test
    public void testSearchAndAddToCart() throws InterruptedException {
        // open browser then go to url
        setup();

        // search product
        HomePage home = new HomePage(driver);
        home.searchProduct("kursi");


        // get product info
        SearchResultsPage results = new SearchResultsPage(driver);
        ProductInfo productInfo = results.selectFirstProduct();
        String expectedProduct = productInfo.getName();


        // add product to cart
        ProductPage product = new ProductPage(driver);
        product.addToCart(productInfo.getWebElement());


        // open cart page
        CartPage cart = new CartPage(driver);
        cart.openCart();


        // verify product info
        String actualProduct = cart.getProductName();
        Assert.assertEquals(actualProduct, expectedProduct);



        // process order
        OrderPage order = new OrderPage(driver);
        order.processOrder();


        // process delivery
        DeliveryPage delivery = new DeliveryPage(driver);
        delivery.processDelivery();


        // close browser
        tearDown();
    }
}