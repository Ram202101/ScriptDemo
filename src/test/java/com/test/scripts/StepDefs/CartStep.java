package com.test.scripts.StepDefs;

import com.demo.scripts.TestContext.TestContext;
import com.demo.scripts.framework.PageObjectManager;
import io.cucumber.java.en.Then;

public class CartStep {

    protected PageObjectManager pageObjectManager;

    public CartStep(TestContext testContext) {
        testContext.getDriver();
        pageObjectManager = testContext.getObjectManager();
    }

    @Then("I am able to verify the item in my cart")
    public void i_am_able_to_verify_the_item_in_my_cart() throws InterruptedException {
        pageObjectManager.getCart().validatecartitems();
    }
}
