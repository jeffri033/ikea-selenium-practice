# IKEA Online Store Project

## Description
Implementation of Behavior-Driven Development (BDD) testing on website https://www.ikea.co.id/ using **Cucumber**

## Features: Shopping functionality
  Scenario: Add product to cart and proceed to checkout
    - Given I open the IKEA e-commerce website
    - When I search for "kursi"
    - And I add the product "RENBERGET" to cart
    - And I proceed to checkout
    - And I fill in form delivery
    - And I select payment method
    - Then A confirmation message should be displayed

## How to Run
1. Clone the repo
2. Run `mvn test`